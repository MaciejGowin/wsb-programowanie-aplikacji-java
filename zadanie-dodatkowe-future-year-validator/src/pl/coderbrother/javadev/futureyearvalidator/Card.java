package pl.coderbrother.javadev.futureyearvalidator;

import pl.coderbrother.javadev.futureyearvalidator.validator.FutureYear;

public class Card {
    @FutureYear
    private final Integer expiryYear;

    public Card(Integer expiryYear) {
        this.expiryYear = expiryYear;
    }

    @Override
    public String toString() {
        return String.format("Card: {expiryYear: %s}", expiryYear);
    }
}
