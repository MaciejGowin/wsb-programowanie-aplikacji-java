package pl.wsb.programowaniejava.maciejgowin.przyklad69.singleton;

public enum CounterEnum {
    INSTANCE;

    private int value;

    public void increment() {
        value++;
    }

    public int value() {
        return value;
    }
}
