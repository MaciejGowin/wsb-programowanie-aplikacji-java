public class Main {

    public static void main(String[] args) {
        int[][] items = { {11}, {21, 22}, {31, 32, 33} };

        for (int[] subItems: items) {
            for (int subItem: subItems) {
                System.out.println("item: " + subItem);
            }
        }
    }
}
