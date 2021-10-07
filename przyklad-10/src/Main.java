class Calculator {

    static int sum(int a, int b) {
        return a + b;
    }

    static int sum(int a, int b, int c) {
        return sum(a, b) + c;
    }

    static double sum(double a, double b) {
        return a + b;
    }
}

public class Main {

    public static void main(String[] args) {

        System.out.println(Calculator.sum(1, 2));
        System.out.println(Calculator.sum(1, 2, 3));
        System.out.println(Calculator.sum(1.0, 2.0));
    }
}
