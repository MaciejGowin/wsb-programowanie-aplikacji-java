import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(2, 3));
        rectangles.add(new Rectangle(6, 3));
        rectangles.add(new Rectangle(1, 9));
        rectangles.add(new Rectangle(7, 7));
        rectangles.add(new Rectangle(8, 2));

        print(rectangles);
        Collections.sort(rectangles);
        print(rectangles);
    }

    public static void print(List<Rectangle> rectangles) {
        System.out.print("Items");
        for (Rectangle rectangle: rectangles) {
            System.out.print(": " + rectangle);
        }
        System.out.println();
    }
}
