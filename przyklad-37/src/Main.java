import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Map<Integer, String> userPerId = new HashMap<>();
        userPerId.put(1, "mark");
        userPerId.put(2, "elisabeth");
        userPerId.put(3, "george");
        System.out.println("Users: " + userPerId);

        // Function
        Function<Integer, String> defaultUser = key -> "unknown-" + key;
        String userId3 = userPerId.computeIfAbsent(3, defaultUser);
        System.out.println("userId3: " + userId3);
        String userId4 = userPerId.computeIfAbsent(4, defaultUser);
        System.out.println("userId4: " + userId4);
        System.out.println("Users: " + userPerId);

        // BiFunction
        userPerId.replaceAll((key, value) -> !value.endsWith("-" + key) ? value + "-" + key : value);
        System.out.println("Users: " + userPerId);

        // Consumer
        userPerId.values().forEach(userName ->  System.out.printf("User name: %s%n", userName));
    }
}
