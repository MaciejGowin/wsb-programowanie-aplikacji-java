import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

public class Main {

    private static final String INPUT_FILE =
            "/Users/gowinm/dev/external-projects/wsb-programowanie-aplikacji-java/przyklad-42/src/input";
    private static final String OUTPUT_FILE =
            "/Users/gowinm/dev/external-projects/wsb-programowanie-aplikacji-java/przyklad-42/src/output";

    public static void main(String args[]) {
        readFile(INPUT_FILE).ifPresent(content -> writeFile(OUTPUT_FILE, content + LocalDateTime.now()));
    }

    public static Optional<String> readFile(String filename) {
        FileInputStream input = null;
        try {
            input = new FileInputStream(filename);
            StringBuilder stringBuilder = new StringBuilder();

            int i = input.read();
            while(i != -1) {
                stringBuilder.append((char) i);
                i = input.read();
            }

            input.close();
            return Optional.of(stringBuilder.toString());
        }  catch(Exception ex) {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException ioEx) {
            }
            System.out.println("Reading failed: " + ex.getMessage());
        }
        return Optional.empty();
    }

    public static void writeFile(String filename, String content) {
        FileOutputStream output = null;
        try {
            output = new FileOutputStream(filename);
            byte[] array = content.getBytes();
            output.write(array);
            output.close();
        } catch(Exception ex) {
            try {
                if (output != null) {
                    output.close();
                }
            } catch (IOException ioEx) {
            }
            System.out.println("Writing failed: " + ex.getMessage());
        }
    }
}
