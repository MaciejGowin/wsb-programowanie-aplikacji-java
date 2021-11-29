package pl.wsb.programowaniejava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

public class FileUtils {

    public static Optional<Long> countLines(final String filename) {
        try {
            return of(Files.readAllLines(Path.of(filename)).stream().filter(FileUtils::isNotBlank).count());
        } catch (IOException ex) {
            System.out.println("Failed to load file: " + ex.getMessage());
            return empty();
        }
    }

    public static boolean isNotBlank(final String value) {
        return value != null && value.replaceAll("\\s","").length() > 0;
    }
}
