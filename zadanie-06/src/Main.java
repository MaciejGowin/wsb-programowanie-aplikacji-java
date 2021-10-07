public class Main {

    public static void main(String[] args) {
        int[] items = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int sum = 0;
        for (int item: items) {
            sum += item;
        }

        int average = sum / items.length;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }
}
