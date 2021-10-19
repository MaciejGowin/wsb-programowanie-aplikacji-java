public class Main {

    public static void main(String[] args) {
        testArray(new int[][]{{1, 2, 3}, {1, 2}, {1}});
        testArray(new int[][]{{4, 5, 6, 7}, {1, 2}, {1}});
        testArray(new int[][]{{}, {}, {1}});
    }

    public static void testArray(int[][] items) {
        System.out.println("-----");
        System.out.printf("Original array: %s%n", ArrayString.asString(items));
        System.out.printf("Reversed array: %s%n", ArrayString.asString(reorder(items)));
    }

    public static int[][] reorder(int[][] items) {
        int subItemsMaxLength = 0;
        for (int[] subItems: items) {
            if (subItems.length > subItemsMaxLength) {
                subItemsMaxLength = subItems.length;
            }
        }

        int[][] reversedItems = new int[subItemsMaxLength][];
        for (int i = 0; i < subItemsMaxLength; i++) {
            int subItemsWithLengthI = 0;
            for (int[] subItems: items) {
                if (subItems.length > i) {
                    subItemsWithLengthI++;
                }
            }

            int[] reversedSubItems = new int[subItemsWithLengthI];
            int currentReversedSubItemsIndex = 0;
            for (int[] subItems: items) {
                if (subItems.length > i) {
                    reversedSubItems[currentReversedSubItemsIndex++] = subItems[i];
                }
            }

            reversedItems[i] = reversedSubItems;
        }

        return reversedItems;
    }
}
