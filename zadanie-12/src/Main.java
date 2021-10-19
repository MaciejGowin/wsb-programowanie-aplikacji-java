public class Main {

    public static void main(String[] args) {
        Person person1 = new Person("Jan", "Kowalski", 1953);
        describe(person1);

        person1.setYearOfBirth(1964);
        describe(person1);

        describe(new Person("Andrzej", null, 1989));
        describe(new Person(null, "Nowak", 1976));
        describe(new Person(null, null, 1991));
    }

    public static void describe(Person person) {
        System.out.printf("Person: %s: age: %d%n", person.getFullName(), person.getAge());
    }
}
