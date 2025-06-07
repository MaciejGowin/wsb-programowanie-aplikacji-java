package pl.wsb.programowaniejava.maciejgowin.gatling.locate;

import java.util.concurrent.ThreadLocalRandom;

public class Sleeper {

    public static void randomSleep() {
        try {
            int sleep = ThreadLocalRandom.current().nextInt(0, 200);
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            // Ignore
        }
    }
}
