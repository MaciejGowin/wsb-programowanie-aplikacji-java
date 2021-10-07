package cars;

public class CarCalculator {
    public static int countBrand(String brand, Car[] cars) {
        int sum = 0;
        for (Car car: cars) {
            if (car.brand == brand) {
                sum++;
            }
        }
        return sum;
    }
}
