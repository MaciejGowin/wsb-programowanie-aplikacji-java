import java.util.Scanner;

public class Main {

    private static final int MAGIC_NUMBER = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int inputInt = 0;
        int sumOfEven = 0;
        int sumOfOdd = 0;
        do {
            System.out.printf("Please specify an integer or %s to break: ", MAGIC_NUMBER);
            inputInt = input.nextInt();

            if (inputInt % 2 == 0) {
                sumOfEven += inputInt;
            } else {
                sumOfOdd += inputInt;
            }

        } while (inputInt != MAGIC_NUMBER);

        System.out.printf("Sum of even: %s%n", sumOfEven);
        System.out.printf("Sum of odd: %s%n", sumOfOdd);
    }
}
