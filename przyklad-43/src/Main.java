import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.Optional;

public class Main {

    private static final String INPUT_FILE =
            "/Users/gowinm/dev/external-projects/wsb-programowanie-aplikacji-java/przyklad-43/src/input";
    private static final String OUTPUT_FILE =
            "/Users/gowinm/dev/external-projects/wsb-programowanie-aplikacji-java/przyklad-43/src/output";

    public static void main(String args[]) {
        readFile(INPUT_FILE).ifPresent(content -> writeFile(OUTPUT_FILE, content + LocalDateTime.now()));
    }

    private static Optional<String> readFile(String filename) {
        char[] array = new char[1];

        try (FileReader input = new FileReader(filename)) {
            StringBuilder stringBuilder = new StringBuilder();

            int result = input.read(array);
            while (result != -1) {
                stringBuilder.append(array);
                result = input.read(array);
            }

            return Optional.of(stringBuilder.toString());
        } catch(Exception ex) {
            System.out.println("Reading failed: " + ex.getMessage());
        }

        return Optional.empty();
    }

    private static void writeFile(String filename, String content) {
        try (FileWriter output = new FileWriter(filename)) {
            output.write(content);
        } catch (Exception ex) {
            System.out.println("Writing failed: " + ex.getMessage());
        }
    }
}
