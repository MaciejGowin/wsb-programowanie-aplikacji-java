package pl.wsb.programowaniejava.maciejgowin.przyklad69.singleton;

public class Main {

    public static void main2(String[] args) {
        Counter counter1 = Counter.getInstance();
        Counter counter2 = Counter.getInstance();

        counter1.increment();
        counter2.increment();
        Counter.getInstance().increment();

        System.out.printf("Value: %d%n", counter1.value());
        System.out.printf("Value: %d%n", counter2.value());
        System.out.printf("Value: %d%n", Counter.getInstance().value());
    }

    public static void main(String[] args) {
        CounterEnum counter1 = CounterEnum.INSTANCE;
        CounterEnum counter2 = CounterEnum.INSTANCE;

        counter1.increment();
        counter2.increment();
        CounterEnum.INSTANCE.increment();

        System.out.printf("Value: %d%n", counter1.value());
        System.out.printf("Value: %d%n", counter2.value());
        System.out.printf("Value: %d%n", CounterEnum.INSTANCE.value());
    }
}
