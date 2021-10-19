import java.util.ArrayList;
import java.util.Arrays;
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
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Gary", "Jessica", "George", "Elisabeth", "George");

        forEach();
        customToListCollector(names);
        collectorsToList(names);
        groupingBy(names);
        joining(names);
    }

    public static void forEach() {
        Stream.of("Gary", "Jessica", "George", "Elisabeth", "George")
                .forEach(name -> System.out.println("Name: " + name));

        Stream.empty()
                .forEach(name -> System.out.println("Name: " + name));
    }

    public static void customToListCollector(List<String> initNames) {
        List<String> names = initNames.stream()
                .filter(name -> name.startsWith("G"))
                .map(name -> name.toUpperCase())
                .distinct()
                .sorted()
                .collect(new Collector<String, List<String>, List<String>>() {
                    @Override
                    public Supplier<List<String>> supplier() {
                        return () -> new ArrayList<String>();
                    }

                    @Override
                    public BiConsumer<List<String>, String> accumulator() {
                        return (items, item) -> items.add(item);
                    }

                    @Override
                    public BinaryOperator<List<String>> combiner() {
                        return (leftItems, rightItems) -> {
                            leftItems.addAll(rightItems);
                            return leftItems;
                        };
                    }

                    @Override
                    public Function<List<String>, List<String>> finisher() {
                        return items -> items;
                    }

                    @Override
                    public Set<Characteristics> characteristics() {
                        return new HashSet<>();
                    }
                });
        System.out.println("Names: " + names);
    }

    public static void collectorsToList(List<String> initNames) {
        List<String> names = initNames.stream()
                .filter(name -> name.startsWith("G"))
                .map(name -> name.toUpperCase())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Names: " + names);
    }

    public static void groupingBy(List<String> initNames) {
        Map<String, List<String>> names = initNames.stream()
                .collect(Collectors.groupingBy(name -> name.substring(0, 1)));

        System.out.println("Names: " + names);
    }

    public static void joining(List<String> initNames) {
        String names = initNames.stream().collect(Collectors.joining(" and "));
        System.out.println("Names: " + names);
    }
}
