public class Main {

    public static void main(String[] args) {
        int[] items1 = {1, 2, 3, 4, 5, 6};
        reverse(items1);
        print(items1);

        int[] items2 = {4, 6, 5};
        reverse(items2);
        print(items2);

        int[] items3 = {3};
        reverse(items3);
        print(items3);

        int[] items4 = {};
        reverse(items4);
        print(items4);
    }

    public static void reverse(int[] items) {
        for (int i = 0; i < items.length/2; i++) {
            int temp = items[i];
            items[i] = items[items.length - i - 1];
            items[items.length - i - 1] = temp;
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
