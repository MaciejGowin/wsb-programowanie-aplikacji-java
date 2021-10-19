class Person {

    String firstName;
    String lastName;

    public Person(String lastName) {
        this(null, lastName);
        System.out.println("Invoking: Person(lastName)");
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Invoking: Person(firstName, lastName)");
    }
}

public class Main {

    public static void main(String[] args) {
        System.out.println("== Defined 1");
        Person person1 = new Person("Jan", "Kowalski");
        
        System.out.println("== Defined 2");
        Person person2 = new Person("Kowalski");
    }
}
