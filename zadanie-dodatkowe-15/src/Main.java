import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream.of("This is just test", "Another test STRING")
                .map(StringProcessor::upperCase)
                .map(StringProcessor::letterSpaceSeparated)
                .forEach(System.out::println);
    }
}
