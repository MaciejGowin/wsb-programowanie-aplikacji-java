import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream
                .of(
                        new Person("Andrzej", 1984),
                        new Person("Andrzej", 2020),
                        new Person("       ", 1984),
                        new Person("       ", 2020))
                .forEach(Main::validate);
    }

    public static void validate(Person person) {
        try {
            Validator.validateName(person);
            Validator.validateAdult(person);
        } catch (ValidationException ex) {
            System.out.println("Validation failed: " + ex.getMessage());
        }
    }
}
