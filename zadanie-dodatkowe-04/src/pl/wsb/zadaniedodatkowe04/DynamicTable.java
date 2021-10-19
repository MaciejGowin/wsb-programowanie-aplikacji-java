package pl.wsb.zadaniedodatkowe04;

public class DynamicTable {

    private double[] items = new double[0];

    public void addItem(double newItem) {
        double[] newItems = new double[items.length + 1];
        int index = 0;
        for (double item: items) {
            newItems[index] = item;
            index++;
        }
        newItems[newItems.length - 1] = newItem;
        items = newItems;
    }

    public void deleteItem(int deleteIndex) {
        if (deleteIndex < 0 || deleteIndex > items.length - 1) {
            return;
        }

        double[] newItems = new double[items.length - 1];
        int newIndex = 0;
        int index = 0;
        for (double item: items) {
            if (index != deleteIndex) {
                newItems[newIndex] = item;
                newIndex++;
            }

            index++;
        }
        items = newItems;
    }

    public String toString() {
        String value = "[";
        int index = 0;
        for (double item: items) {
            if (index > 0) {
                value += ", ";
            }
            value += item;
            index++;
        }
        value += "]";
        return value;
    }
}
