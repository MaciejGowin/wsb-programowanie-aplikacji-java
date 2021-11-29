package pl.wsb.programowaniejava.maciejgowin.przyklad73.util;

import pl.wsb.programowaniejava.maciejgowin.przyklad73.simpletype.Main;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ClassPathFile {

    public static String readFile(String filename) throws Exception {
        return String.join("",
                Files.readAllLines(Paths.get(Main.class.getResource("/" + filename).toURI())));
    }
}
