package pl.wsb.zadaniedodatkowe02;

public class Main {

    public static void main(String[] args) {
        print(reverse(new String[] {"A", "B", "C"}));
        print(reverse(new String[] {"A", "B"}));
        print(reverse(new String[] {"A"}));
        print(reverse(new String[] {}));
    }

    public static String[] reverse(String[] items) {
        String[] reversedItems = new String[items.length];
        int lastIndex = items.length - 1;
        for (String item: items) {
            reversedItems[lastIndex--] = item;
        }
        return reversedItems;
    }

    public static void print(String[] items) {
        System.out.print("Table:");
        for (String item: items) {
            System.out.print(" " + item);
        }
        System.out.println();
    }
}
