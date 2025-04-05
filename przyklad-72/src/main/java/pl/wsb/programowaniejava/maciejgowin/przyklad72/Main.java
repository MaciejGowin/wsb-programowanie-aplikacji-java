package pl.wsb.programowaniejava.maciejgowin.przyklad72;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Application: start");
        new LogMe().test();
        LOGGER.warn("Minor update");
        LOGGER.error("Severe update");
        LOGGER.info("Application: end");

        try {
            throwException();
        } catch (Exception e) {
            LOGGER.warn("Exception occurred: {}", e.getMessage());
        }
    }

    public static void throwException() throws Exception {
        throw new Exception("Something went wrong");
    }
}
