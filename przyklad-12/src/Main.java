public class Main {

    public static void main(String[] args) {
        breakLine();

        int loop1Invocations = 0;
        for (int i = 0; i < 10; i++) {
            loop1Invocations++;
            printIteration("loop1", i);
        }
        printTotal("loop1", loop1Invocations);

        breakLine();

        int loop2Invocations = 0;
        for (int i = 0; i < 10; i = i + 3) {
            loop2Invocations++;
            printIteration("loop2", i);
        }
        printTotal("loop2", loop2Invocations);

        breakLine();
    }

    public static void printIteration(String loopName, int index) {
        System.out.printf("Loop: %s: current index: %d%n", loopName, index);
    }

    public static void printTotal(String loopName, int index) {
        System.out.printf("Loop: %s: invoked: %d times%n", loopName, index);
    }

    public static void breakLine() {
        System.out.println("----------");
    }
}
