public class Main {

    public static void main(String[] args) {
        System.out.printf("(0, 2): %d%n", gcd(0, 2));
        System.out.printf("(2, 4): %d%n", gcd(2, 4));
        System.out.printf("(18, 27): %d%n", gcd(18, 27));
        System.out.printf("(27, 18): %d%n", gcd(27, 18));
        System.out.printf("(2392560, 2542095): %d%n", gcd(2392560, 2542095));
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
