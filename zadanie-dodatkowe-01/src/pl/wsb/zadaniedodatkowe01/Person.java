package pl.wsb.zadaniedodatkowe01;

public class Person {
    public String firstName;
    public String lastName;

    public String getFullName() {
        if (firstName != null && lastName != null) {
            return firstName + " " + lastName;
        } else if (lastName != null) {
            return lastName;
        } else if (firstName != null) {
            return firstName;
        } else {
            return null;
        }
    }

    public static Person constructPerson(String firstName, String lastName) {
        Person person = new Person();
        person.firstName = firstName;
        person.lastName = lastName;
        return person;
    }
}
