import java.time.LocalDate;

import static java.util.Optional.ofNullable;

public class Validator {

    public static void validateName(Person person) throws ValidationException {
        boolean valid = ofNullable(person)
                .map(Person::getName)
                .map(String::trim)
                .filter(v -> v.length() > 0)
                .isPresent();

        if (!valid) {
            throw new ValidationException(String.format("Person has invalid name: %s", person));
        }
    }

    public static void validateAdult(Person person) throws ValidationException {
        boolean valid = ofNullable(person)
                .map(Person::getYearOfBirth)
                .map(year -> LocalDate.now().getYear() - year)
                .filter(age -> age >= 18)
                .isPresent();

        if (!valid) {
            throw new ValidationException(String.format("Person is not adult: %s", person));
        }
    }
}
