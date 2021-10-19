import validator.NotEmpty;
import validator.Validator;

class Sample {
    @NotEmpty
    private String valueNotEmpty;
    private String valueAny;

    public Sample(String valueNotEmpty, String valueAny) {
        this.valueNotEmpty = valueNotEmpty;
        this.valueAny = valueAny;
    }

    @Override
    public String toString() {
        return String.format("{valueNotEmpty: %s, valueAny: %s}", valueNotEmpty, valueAny);
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        Sample[] samples = {
                new Sample("test", "test"),
                new Sample("test", null),
                new Sample(null, "test"),
                new Sample(null, null)
        };

        for (Sample sample: samples) {
            System.out.printf("%s: is valid: %s%n", sample.toString(), Validator.validate(sample));
        }
    }
}
