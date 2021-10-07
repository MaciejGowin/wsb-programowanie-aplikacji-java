class Car {
    String brand;
}

class CarCalculator {
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

public class Main {

    public static void main(String[] args) {
        Car car1 = new Car();
        car1.brand = "BMW";

        Car car2 = new Car();
        car2.brand = "Mercedes";

        Car car3 = new Car();
        car3.brand = "BMW";

        Car[] cars = {car1, car2, car3};
        CarCalculator carCalculator = new CarCalculator();

        System.out.printf("Sum of BMW: %s\n", CarCalculator.countBrand("BMW", cars));
        System.out.printf("Sum of Mercedes: %s\n", CarCalculator.countBrand("Mercedes", cars));
        System.out.printf("Sum of Opel: %s\n", carCalculator.countBrand("Opel", cars));
    }

    public static double eurToPln(double eur) {
        return eur * 4.25;
    }
}
