public class Main {

    public static void main(String[] args) {
        double[] prices = { 19.92, 12.95, 234.39, 95.95};
        double totalPrice = 0.0;
        double totalPriceDiscounted = 0.0;

        for (int i = 0; i < prices.length; i++) {
            totalPrice += prices[i];
            totalPriceDiscounted += priceAfterDiscount(prices[i], i * 10);
        }

        System.out.printf("Price: total: %s: total discounted: %s%n", totalPrice, totalPriceDiscounted);
    }

    public static double priceAfterDiscount(double price, int discountInPercent) {
        return price * (100 - discountInPercent) / 100;
    }
}
