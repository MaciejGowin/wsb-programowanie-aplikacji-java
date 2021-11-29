package pl.wsb.programowaniejava.maciejgowin.przyklad69.singleton;

public class Counter {

    private static final Counter INSTANCE = new Counter();

    private int value;

    private Counter() {
    }

    public static Counter getInstance() {
        return INSTANCE;
    }

    public void increment() {
        value++;
    }

    public int value() {
        return value;
    }
}
