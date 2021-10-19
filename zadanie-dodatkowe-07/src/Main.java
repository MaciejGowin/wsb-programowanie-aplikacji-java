public class Main {

    public static void main(String[] args) {
        System.out.printf("silnia(%d) = %d, %d%n", 0, factorial(0), factorialRecursive(0));
        System.out.printf("silnia(%d) = %d, %d%n", 1, factorial(1), factorialRecursive(1));
        System.out.printf("silnia(%d) = %d, %d%n", 2, factorial(2), factorialRecursive(2));
        System.out.printf("silnia(%d) = %d, %d%n", 3, factorial(3), factorialRecursive(3));
        System.out.printf("silnia(%d) = %d, %d%n", 4, factorial(4), factorialRecursive(4));
        System.out.printf("silnia(%d) = %d, %d%n", 5, factorial(5), factorialRecursive(5));
    }

    public static int factorialRecursive(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorialRecursive(n - 1);
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
