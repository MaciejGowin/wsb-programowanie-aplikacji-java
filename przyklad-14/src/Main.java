import java.util.Scanner;

public class Main {

    private static final int MAGIC_NUMBER = 7;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int inputInt = 0;
        do {
            System.out.print("Please specify an integer: ");
            inputInt = input.nextInt();
        } while (inputInt != MAGIC_NUMBER);

        System.out.println("Finally!");
    }
}
