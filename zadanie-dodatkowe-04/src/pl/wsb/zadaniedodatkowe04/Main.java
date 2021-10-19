package pl.wsb.zadaniedodatkowe04;

public class Main {

    public static void main(String[] args) {
        System.out.println("= Adding");
        DynamicTable table0 = new DynamicTable();

        DynamicTable table1 = new DynamicTable();
        table1.addItem(1.0);

        DynamicTable table2 = new DynamicTable();
        table2.addItem(1.0);
        table2.addItem(2.0);

        DynamicTable table3 = new DynamicTable();
        table3.addItem(1.0);
        table3.addItem(2.0);
        table3.addItem(3.0);

        System.out.printf("Table: %s%n", table0.toString());
        System.out.printf("Table: %s%n", table1.toString());
        System.out.printf("Table: %s%n", table2.toString());
        System.out.printf("Table: %s%n", table3.toString());

        System.out.println("= Deleting");
        table3.deleteItem(1);
        System.out.printf("Table: %s%n", table3.toString());
        table3.deleteItem(1);
        System.out.printf("Table: %s%n", table3.toString());
        table3.deleteItem(-1);
        System.out.printf("Table: %s%n", table3.toString());
        table3.deleteItem(2);
        System.out.printf("Table: %s%n", table3.toString());
        table3.deleteItem(0);
        System.out.printf("Table: %s%n", table3.toString());
    }
}
