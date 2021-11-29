package pl.wsb.programowaniejava.maciejgowin.przyklad63;

public class Main {

    public static void main(String[] args) {
        Runnable r1 = () -> {
            safeSleep(3000);
            System.out.println("R1: " + Thread.currentThread().getName());
        };
        Runnable r2 =  () -> {
            safeSleep(1000);
            System.out.println("R2: " + Thread.currentThread().getName());
        };

        System.out.println("Start: " + Thread.currentThread().getName());
        new Thread(r1).start();
        new Thread(r2).start();
        System.out.println("End: " + Thread.currentThread().getName());
    }

    private static void safeSleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
