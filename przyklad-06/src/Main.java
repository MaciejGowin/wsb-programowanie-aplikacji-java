public class Main {

    public static void main(String[] args) {
        double triangle1 = triangleField(2.0, 3.0);
        System.out.println("Triangle 1: " + triangle1);
        System.out.println("Triangle 2: " + triangleField(4.0, 6.0));
    }

    public static double triangleField(double a, double h) {
        return a * h / 2;
    }
}
