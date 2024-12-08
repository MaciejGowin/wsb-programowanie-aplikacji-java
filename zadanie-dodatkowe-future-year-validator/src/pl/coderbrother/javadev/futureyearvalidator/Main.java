package pl.coderbrother.javadev.futureyearvalidator;

import pl.coderbrother.javadev.futureyearvalidator.validator.Validator;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        List<Object> objects = List.of(
                new Card(2030),
                new Card(2024),
                new Card(null),
                new Card(2000),
                new Passport(2045),
                new Passport(2011)
        );

        for (Object object: objects) {
            System.out.printf("%s: is valid: %s%n", object, Validator.validate(object));
        }
    }
}
