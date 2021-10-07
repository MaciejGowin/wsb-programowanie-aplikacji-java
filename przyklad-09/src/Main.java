class Car {
    static int speedLimit = 180;
}

public class Main {

    public static void main(String[] args) {
        Car bmw = new Car();
        Car mercedes = new Car();

        System.out.printf("Car speed limit: %s\n", Car.speedLimit);
        System.out.printf("Car speed limit: %s\n", bmw.speedLimit);
        System.out.printf("Car speed limit: %s\n", mercedes.speedLimit);

        Car.speedLimit = 190;

        System.out.printf("Car speed limit: %s\n", Car.speedLimit);
        System.out.printf("Car speed limit: %s\n", bmw.speedLimit);
        System.out.printf("Car speed limit: %s\n", mercedes.speedLimit);


        Car.speedLimit = 200;

        System.out.printf("Car speed limit: %s\n", Car.speedLimit);
        System.out.printf("Car speed limit: %s\n", bmw.speedLimit);
        System.out.printf("Car speed limit: %s\n", mercedes.speedLimit);
    }
}
