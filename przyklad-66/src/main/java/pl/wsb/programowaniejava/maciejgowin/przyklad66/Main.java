package pl.wsb.programowaniejava.maciejgowin.przyklad66;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread thread1 = new CounterThread(counter);
        Thread thread2 = new CounterThread(counter);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.printf("Counter: %d%n", counter.get());
    }
}
