package pl.wsb.programowaniejava.maciejgowin.przyklad69.observer;

public class Student {

    private final int id;

    public Student(int id) {
        this.id = id;
    }

    public void learn(String item) {
        System.out.printf("Student %d: learn: %s%n", id, item);
    }

    public int getId() {
        return id;
    }
}
