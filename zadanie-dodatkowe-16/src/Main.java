import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Map<String, List<Double>> pricesPerFruit = new HashMap<>();
        pricesPerFruit.put("Banana", List.of(2.5, 4.6));
        pricesPerFruit.put("Apple", List.of(1.1, 2.3));

        Map<String, Double> averagePricePerFruit = pricesPerFruit.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> average(e.getValue())));
        System.out.println(averagePricePerFruit);
    }

    public static Double average(List<Double> values) {
        if (values == null || values.size() == 0) {
            return 0.0;
        }

        Double sum = 0.0;
        for (Double value: values) {
            sum += (value != null ? value : 0.0);
        }
        return sum/values.size();
    }
}
