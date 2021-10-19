import java.util.Arrays;
import java.util.Random;

class StopWatch {
    private long start = 0L;

    public void start() {
        start = System.currentTimeMillis();
    }

    public long stop() {
        return System.currentTimeMillis() - start;
    }
}

class RandomGenerator {
    public static Random RANDOM = new Random();

    public static int[] randomTable(int length) {
        int[] items = new int[length];
        for (int i = 0; i < length; i++) {
            items[i] = RANDOM.nextInt();
        }
        return items;
    }
}

public class Main {

    public static void main(String[] args) {
        testPerformance(1000);
        testPerformance(10000);
        testPerformance(100000);
    }

    public static void testPerformance(int length) {
        StopWatch stopWatch = new StopWatch();
        int[] items = RandomGenerator.randomTable(length);

        int[] bubleSortItems = Arrays.copyOf(items, items.length);
        stopWatch.start();
        bubleSort(bubleSortItems);
        System.out.printf("items: %d: bubleSort: %d%n", bubleSortItems.length, stopWatch.stop());

        int[] sortItems = Arrays.copyOf(items, items.length);
        stopWatch.start();
        Arrays.sort(sortItems);
        System.out.printf("items: %d: sort: %d%n", sortItems.length, stopWatch.stop());
    }

    public static void bubleSort(int[] items) {
        int n = items.length;
        for(int i=0; i<n ;i++) {
            for (int j = 1; j < n - i; j++) {
                if (items[j - 1] > items[j]) {
                    // Replace items
                    int temp = items[j - 1];
                    items[j - 1] = items[j];
                    items[j] = temp;
                }
            }
        }
    }
}
