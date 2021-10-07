public class Converter {

    public static void main(String[] args) {
        int priceInEur = 5;
        double eurToPlnRatio = 4.25;
        double priceInPln = priceInEur * eurToPlnRatio;

        System.out.printf("Cena w EUR: %s\n", priceInEur);
        System.out.printf("Przelicznik: %s\n", eurToPlnRatio);
        System.out.printf("Cena w PLN: %s\n", priceInPln);
    }
}
