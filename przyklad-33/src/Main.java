import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("item1");
        items.add("item2");
        items.add("item3");

        for (int i = 0; i < items.size(); i++) {
            System.out.println("for: " + items.get(i));
        }

        for (String item: items) {
            System.out.println("foreach: " + item);
        }

        Iterator<String> iterator = items.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator: " + iterator.next());
        }
    }
}
