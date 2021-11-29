import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        System.out.println("multiply");
        System.out.println(multiply(2, 1, 1, 1, 2, 2, 3));
        System.out.println(multiply(3, 1, 1, 1, 2, 2, 3));

        System.out.println("multiplyWithStream");
        System.out.println(multiplyWithStream(2, 1, 1, 1, 2, 2, 3));
        System.out.println(multiplyWithStream(3, 1, 1, 1, 2, 2, 3));
    }

    private static Map<Integer, Integer> multiply(Integer multiplier, Integer... numbers) {
        Map<Integer, Integer> multiplied = new HashMap<>();
        for (Integer number: numbers) {
            if (!multiplied.containsKey(number)) {
                multiplied.put(number, number * multiplier);
            }
        }
        return multiplied;
    }

    private static Map<Integer, Integer> multiplyWithStream(Integer multiplier, Integer... numbers) {
        return Stream.of(numbers).distinct().collect(Collectors.toMap(v -> v, v -> v * multiplier));
    }
}
