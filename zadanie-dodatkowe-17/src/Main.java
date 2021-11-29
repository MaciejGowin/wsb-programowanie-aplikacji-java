import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> names = List.of("gary", "George", "Anna", "", "");

        Map<String, List<String>> defaultByFirstLetter = names.stream()
                .collect(Collectors.groupingBy(Main::firstOrEmpty));
        System.out.println("Names: " + defaultByFirstLetter);

        Map<String, List<String>> customByFirstLetter = names.stream()
                .collect(new Collector<String, Map<String, List<String>>, Map<String, List<String>>>() {
                    @Override
                    public Supplier<Map<String, List<String>>> supplier() {
                        return HashMap::new;
                    }

                    @Override
                    public BiConsumer<Map<String, List<String>>, String> accumulator() {
                        return (map, value) -> {
                            String letter = firstOrEmpty(value);
                            map.putIfAbsent(letter, new ArrayList<>());
                            map.get(letter).add(value);
                        };
                    }

                    @Override
                    public BinaryOperator<Map<String, List<String>>> combiner() {
                        return (left, right) -> {
                            right.forEach((key, value) -> {
                                left.putIfAbsent(key, new ArrayList<>());
                                left.get(key).addAll(value);
                            });
                            return left;
                        };
                    }

                    @Override
                    public Function<Map<String, List<String>>, Map<String, List<String>>> finisher() {
                        return Function.identity();
                    }

                    @Override
                    public Set<Characteristics> characteristics() {
                        return new HashSet<>();
                    }
                });
        System.out.println("Names: " + customByFirstLetter);
    }

    private static String firstOrEmpty(String value) {
        return value != null && value.length() > 0 ? value.substring(0, 1).toUpperCase() : "";
    }
}
