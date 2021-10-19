import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String QUIT = "q";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Integer> countPerValue = new HashMap<>();
        while(true) {
            System.out.print("Podaj słowo (lub q aby przerwać): ");
            String value = input.next();
            if (value.equals(QUIT)) {
                break;
            }
            countPerValue.put(value, countPerValue.getOrDefault(value, 0) + 1);
        }

        System.out.printf("Wystąpienia słów: %s%n", countPerValue);
    }
}
