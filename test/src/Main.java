class FirstThread extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println("Thread name: " + getName() + isAlive());
        }
    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");
        Thread thread1 = new FirstThread();
        thread1.setDaemon(true);
        thread1.start();

        Thread.sleep(10000);

        System.out.println("Finished");
    }
}
