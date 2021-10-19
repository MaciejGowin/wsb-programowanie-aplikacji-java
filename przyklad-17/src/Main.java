class Person {
    String firstName;
    String lastName;

    public Person(String newFirstName, String newLastName) {
        firstName = newFirstName;
        lastName = newLastName;
    }

    public String getFullName() {
        return String.format("%s %s", dashOnNull(firstName), dashOnNull(lastName));
    }

    public static String dashOnNull(String value) {
        return value != null ? value: "-";
    }
}

public class Main {

    public static void main(String[] args) {
        Person[] persons = {
                new Person("Jan", "Kowalski"),
                new Person("Andrzej", null),
                new Person(null, "Nowak"),
                new Person(null, null)};

        for (Person person: persons) {
            System.out.printf("Person: %s%n", person.getFullName());
        }
    }
}
