import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Gary");
        names.add("Jessica");
        names.add("George");
        names.add("Elisabeth");
        names.add("George");

        names.stream()
                .map(name -> {
                    System.out.printf("Mapping 1: %s%n", name);
                    return name.toUpperCase();
                });

        names.stream()
                .map(name -> {
                    System.out.printf("Mapping 2: %s%n", name);
                    return name.toUpperCase();
                })
                .forEach(name -> {
                });

        List<String> upperCaseNames = names.stream()
                .map(name -> {
                    System.out.printf("Mapping 3: %s%n", name);
                    return name.toUpperCase();
                })
                .collect(Collectors.toList());
    }
}
