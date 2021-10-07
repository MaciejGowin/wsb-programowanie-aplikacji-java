class Car {
    String brand = "Unknown";
    boolean engineStarted = false;

    void startEngine() {
        engineStarted = true;
    }

    void stopEngine() {
        engineStarted = false;
    }
}

public class Main {

    public static void main(String[] args) {
        Car unknown = new Car();

        Car bmw = new Car();
        bmw.brand = "BMW";
        bmw.startEngine();

        Car mercedes = new Car();
        mercedes.brand = "Mercedes";
        mercedes.startEngine();
        mercedes.stopEngine();

        System.out.print("\nSummary:\n");
        System.out.printf("Car %s with engine %s\n", unknown.brand, onOrOff(unknown.engineStarted));
        System.out.printf("Car %s with engine %s\n", bmw.brand, onOrOff(bmw.engineStarted));
        System.out.printf("Car %s with engine %s\n", mercedes.brand, onOrOff(mercedes.engineStarted));
    }

    public static String onOrOff(boolean isStarted) {
        if (isStarted) {
            return "on";
        } else {
            return "off";
        }
    }
}
