package pl.wsb.zadaniedodatkowe03;

public class Main {

    public static void main(String[] args) {

        System.out.println("Max is: " + max(new int[] {1, 2, 3}));
        System.out.println("Max is: " + max(new int[] {-1, -2, -3}));
        System.out.println("Max is: " + max(new int[] {1}));
        System.out.println("Max is: " + max(new int[] {}));
    }

    public static int max(int[] items) {
        if (items.length == 0) {
            return 0;
        }

        int max = items[0];
        for (int item: items) {
            if (item > max) {
                max = item;
            }
        }
        return max;
    }
}
