public class Main {

    public static void main(String[] args) {
        int[] items1 = {6, 5, 4, 3, 2, 1};
        selectionSort(items1);
        print(items1);

        int[] items2 = {1};
        selectionSort(items2);
        print(items2);

        int[] items3 = {};
        selectionSort(items3);
        print(items3);
    }

    public static void selectionSort(int[] items) {
        for (int i = 0; i < items.length - 1; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < items.length; j++) {
                if (items[j] < items[minValueIndex]) {
                    minValueIndex = j;
                }
            }

            if (minValueIndex != i) {
                int minValue = items[minValueIndex];
                items[minValueIndex] = items[i];
                items[i] = minValue;
            }
        }
    }

    public static void print(int[] items) {
        String itemsString = "";
        for (int i = 0; i < items.length; i++) {
            if (i != 0) {
                itemsString += ", ";
            }
            itemsString += items[i];
        }
        System.out.printf("[%s]%n", itemsString);
    }
}
