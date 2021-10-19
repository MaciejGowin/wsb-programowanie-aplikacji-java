public class Main {

    public static void main(String[] args) {
        System.out.println("= Adding");
        UniqueTable table0 = new UniqueTable();

        UniqueTable table1 = new UniqueTable();
        table1.addItem(1.0);

        UniqueTable table2 = new UniqueTable();
        table2.addItem(1.0);
        table2.addItem(2.0);
        table2.addItem(2.0);

        UniqueTable table3 = new UniqueTable();
        table3.addItem(1.0);
        table3.addItem(2.0);
        table2.addItem(2.0);
        table3.addItem(3.0);
        table3.addItem(3.0);
        table3.addItem(3.0);

        System.out.printf("Table: %s%n", table0.toString());
        System.out.printf("Table: %s%n", table1.toString());
        System.out.printf("Table: %s%n", table2.toString());
        System.out.printf("Table: %s%n", table3.toString());

        System.out.println("= Deleting");
        table3.deleteItem(1.0);
        System.out.printf("Table: %s%n", table3.toString());
        table3.deleteItem(1.0);
        System.out.printf("Table: %s%n", table3.toString());
        table3.deleteItem(3.0);
        System.out.printf("Table: %s%n", table3.toString());
        table3.deleteItem(2.0);
        System.out.printf("Table: %s%n", table3.toString());
    }
}
