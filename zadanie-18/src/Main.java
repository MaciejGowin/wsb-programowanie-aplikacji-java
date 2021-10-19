public class Main {

    public static void main(String[] args) {
        IntSet set = new IntSet();
        System.out.printf("Items: %s: total: %d%n", set.toString(), set.size());

        System.out.println("Add 1?: " + set.add(1));
        System.out.println("Add 2?: " + set.add(2));
        System.out.println("Add 5?: " + set.add(5));
        System.out.println("Add 5?: " + set.add(5));
        System.out.println("Add 9?: " + set.add(9));
        System.out.println("Add 7?: " + set.add(7));
        System.out.println("Add 7?: " + set.add(7));
        System.out.println("Add 7?: " + set.add(7));
        System.out.println("Add 5?: " + set.add(5));
        System.out.println("Add 5?: " + set.add(5));

        System.out.printf("Items: %s: total: %d%n", set.toString(), set.size());
        System.out.println("Contains 1?: " + set.contains(1));
        System.out.println("Contains 10?: " + set.contains(10));

        System.out.println("Remove 5?: " + set.remove(5));
        System.out.printf("Items: %s: total: %d%n", set.toString(), set.size());

        System.out.println("Remove 4?: " + set.remove(4));
        System.out.println("Remove 7?: " + set.remove(7));
        System.out.printf("Items: %s: total: %d%n", set.toString(), set.size());
    }
}
