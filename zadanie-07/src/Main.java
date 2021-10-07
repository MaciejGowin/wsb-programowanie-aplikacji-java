public class Main {

    public static void main(String[] args) {
        System.out.printf("2.5 EUR is %s PLN\n", eurToPln(2.5));
        System.out.printf("5.0 EUR is %s PLN\n", eurToPln(5.0));
        System.out.printf("7.5 EUR is %s PLN\n", eurToPln(7.5));
    }

    public static double eurToPln(double eur) {
        return eur * 4.25;
    }
}
