package pl.wsb.programowaniejava.maciejgowin.przyklad67;

public class Main {

    private static int value;
    private static boolean finished;

    private static class Reader extends Thread {
        @Override
        public void run() {
            while (!finished) {
                Thread.yield();
            }
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        new Reader().start();
        finished = true;
        value = 86;
    }
}
