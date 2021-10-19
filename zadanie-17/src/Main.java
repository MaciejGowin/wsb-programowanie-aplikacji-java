public class Main {

    public static void main(String[] args) {
        System.out.println("=== Test 1 ===");
        testQueue(new HeadOnlyIntegerQueue());
        System.out.println("=== Test 2 ===");
        testQueue(new HeadAndTailIntegerQueue());
    }

    public static void testQueue(IntegerQueue queue) {
        queue.addLast(1);
        queue.addLast(2);
        queue.addLast(3);
        queue.addLast(9);
        queue.addLast(8);
        queue.addLast(7);

        System.out.println("Items: " + queue.toString());
        System.out.println("Get: " + queue.getFirst());
        System.out.println("Items: " + queue.toString());
        System.out.println("Get: " + queue.getFirst());
        System.out.println("Get: " + queue.getFirst());
        System.out.println("Items: " + queue.toString());
        System.out.println("Get: " + queue.getFirst());
        System.out.println("Get: " + queue.getFirst());
        System.out.println("Get: " + queue.getFirst());
        System.out.println("Items: " + queue.toString());
        System.out.println("Get: " + queue.getFirst());
        System.out.println("Items: " + queue.toString());
    }
}
