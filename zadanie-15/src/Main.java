public class Main {

    public static void main(String[] args) {
        describe(bubleSort(new int[] {3, 7, 5, 6, 2}));
        describe(bubleSort(new int[] {5, 4, 3, 2, 1}));
        describe(bubleSort(new int[] {54, 134, 53, 253, 31, 341, 73, 23, 985, 234, 22, 345}));
    }

    public static int[] bubleSort(int[] items) {
        int n = items.length;
        for(int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (items[j - 1] > items[j]) {
                    // Replace items
                    int temp = items[j - 1];
                    items[j - 1] = items[j];
                    items[j] = temp;
                }
            }
        }
        return items;
    }

    public static void describe(int[] items) {
        for (int item: items) {
            System.out.print("" + item + ", ");
        }
        System.out.println();
    }
}
