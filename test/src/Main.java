import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}
