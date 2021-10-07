public class Main {

    public static void main(String[] args) {
        int x = 5;
        System.out.println("Break point 1: x = " + x);

        int y = ++x;
        System.out.println("Break point 2: x = " + x);
        System.out.println("Break point 2: y = " + y);

        int z = x++;
        System.out.println("Break point 3: x = " + x);
        System.out.println("Break point 3: z = " + z);
    }
}
