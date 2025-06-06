package pl.wsb.programowaniejava.maciejgowin.przyklad73.util;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ClassPathFile {

    public static String readFile(String filename) throws Exception {
        return String.join("",
                Files.readAllLines(Paths.get(ClassPathFile.class.getResource("/" + filename).toURI())));
    }
}
