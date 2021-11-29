package pl.wsb.programowaniejava.maciejgowin.przyklad71;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    static {
        String path = Main.class.getClassLoader().getResource("logging.properties").getFile();
        System.out.println(path);
        System.setProperty("java.util.logging.config.file", path);
    }

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "Application: start");
        LOGGER.log(Level.WARNING, "Minor update");
        LOGGER.severe("Severe update");
        LOGGER.info("Application: end");
    }
}
