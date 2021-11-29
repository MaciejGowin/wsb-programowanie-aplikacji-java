package pl.wsb.programowaniejava.maciejgowin.przyklad69.observer;

public class Main {

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.addStudent(1);
        teacher.addStudent(2);
        teacher.addStudent(3);

        teacher.teach("English");

        teacher.deleteStudent(1);

        teacher.teach("Spanish");
    }
}
