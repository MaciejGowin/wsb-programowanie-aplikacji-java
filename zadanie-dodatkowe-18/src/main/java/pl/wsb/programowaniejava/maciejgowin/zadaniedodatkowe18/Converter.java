package pl.wsb.programowaniejava.maciejgowin.zadaniedodatkowe18;

import java.util.Optional;

import static java.util.Optional.ofNullable;

public class Converter {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Wrong number of parameters. Should be: [height in cm] [weight in kg]");
            return;
        }

        Optional<Double> bmi =
                asLong(args[0])
                        .filter(height -> height > 0)
                        .flatMap(height -> 
                                asLong(args[1])
                                        .filter(weight -> weight > 0)
                                        .map(weight -> (weight * 10000) / (height * height)));

        if (bmi.isPresent()) {
            System.out.printf("Your BMI: %.2f%n", bmi.get());
        } else {
            System.out.println("Incorrect input parameters. Should be: [height in cm] [weight in kg]");
        }
    }

    public static Optional<Double> asLong(String valueOrNull) {
        return ofNullable(valueOrNull)
                .map(value -> {
                    try {
                        return Double.valueOf(value);
                    } catch (NumberFormatException ex) {
                        return null;
                    }
                });
    }
}
