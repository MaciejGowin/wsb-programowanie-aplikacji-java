public class Main {

    public static void main(String[] args) {
        System.out.printf("Sum of: %s: %d%n", 3, sum(3));
        System.out.printf("Sum of: %s: %d%n", 5, sum(5));
        System.out.printf("Sum of: %s: %d%n", 100, sum(100));

    }

    public static int sum(int n) {
        if (n == 0) {
            return 0;
        }
        return sum(n - 1) + n;
    }
}
