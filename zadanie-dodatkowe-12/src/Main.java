import java.util.Scanner;

public class Main {

    private static final String QUIT = "q";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Container container = new Container();
        while(true) {
            System.out.print("Podaj słowo (lub q aby przerwać): ");
            String value = input.next();
            if (value.equals(QUIT)) {
                break;
            }
            container.add(value);
        }

        System.out.printf("Wystąpienia słów: %s%n", container);
    }
}
