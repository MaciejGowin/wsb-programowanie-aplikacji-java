package pl.wbs.programowaniejava.maciejgowin.przyklad51;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static pl.wbs.programowaniejava.maciejgowin.przyklad51.StringUtils.SPACE;

public class Person {

    private String firstName;
    private String lastName;

    public static Optional<Person> fromSeparated(String name, String separator) {
        String[] nameParts = name.split(separator);
        if (nameParts.length == 2) {
            Person person = new Person();
            person.firstName = nameParts[0].trim();
            person.lastName = nameParts[1].trim();
            return Optional.of(person);
        }
        return Optional.empty();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toSeparated(String separator) {
        return Stream.of(firstName, lastName).filter(Objects::nonNull).collect(Collectors.joining(separator));
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this)  {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }

        Person other = (Person) o;

        return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return toSeparated(SPACE);
    }
}
