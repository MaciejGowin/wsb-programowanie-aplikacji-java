package pl.wsb.programowaniejava.maciejgowin.przyklad65;

public class Counter {

    private int i;

    public synchronized void increment() {
        i = i + 1;
    }

    public int get() {
        return i;
    }
}
