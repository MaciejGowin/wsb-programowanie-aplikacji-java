package pl.coderbrother.javadev.futureyearvalidator;

import pl.coderbrother.javadev.futureyearvalidator.validator.FutureYear;

public class Passport {
    @FutureYear
    private final Integer expiration;

    public Passport(Integer expiration) {
        this.expiration = expiration;
    }

    @Override
    public String toString() {
        return String.format("Passport: {expiration: %s}", expiration);
    }
}
