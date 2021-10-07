public class Main {

    public static void main(String[] args) {
        int a = 5;
        String aCheck = (a % 2 == 0) ? "parzysta" : "nieparzysta";
        System.out.printf("Liczba %s jest %s\n", a, aCheck);

        int b = 6;
        String bCheck = (b % 2 == 0) ? "parzysta" : "nieparzysta";
        System.out.printf("Liczba %s jest %s\n", b, bCheck);
    }
}
