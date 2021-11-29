package pl.wsb.programowaniejava.maciejgowin.przyklad69.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher {

    public List<Student> students = new ArrayList<>();

    public void teach(String item) {
        System.out.printf("Teacher: teach: %s%n", item);
        students.forEach(student -> student.learn(item));
    }

    public void addStudent(int id) {
        students.add(new Student(id));
    }

    public void deleteStudent(int id) {
        students = students.stream()
                .filter(student -> student.getId() != id)
                .collect(Collectors.toList());
    }
}
