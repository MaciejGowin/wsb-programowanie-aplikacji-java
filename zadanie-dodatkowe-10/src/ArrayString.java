public class ArrayString {

    public static String asString(int[][] items) {
        String itemsString = "";
        for (int i = 0; i < items.length; i++) {
            if (i != 0) {
                itemsString += ", ";
            }
            itemsString += asString(items[i]);
        }
        return String.format("[%s]", itemsString);
    }

    public static String asString(int[] items) {
        String itemsString = "";
        for (int i = 0; i < items.length; i++) {
            if (i != 0) {
                itemsString += ", ";
            }
            itemsString += items[i];
        }
        return String.format("[%s]", itemsString);
    }
}
