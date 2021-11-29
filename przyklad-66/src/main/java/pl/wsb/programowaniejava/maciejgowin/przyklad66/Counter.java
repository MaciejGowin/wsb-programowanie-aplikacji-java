package pl.wsb.programowaniejava.maciejgowin.przyklad66;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    private final AtomicInteger i = new AtomicInteger();

    public void increment() {
        i.incrementAndGet();
    }

    public int get() {
        return i.get();
    }
}
