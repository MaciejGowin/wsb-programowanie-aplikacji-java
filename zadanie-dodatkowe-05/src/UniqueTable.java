public class UniqueTable {

    private double[] items = new double[0];

    public void addItem(double newItem) {
        if (!contains(newItem)) {
            double[] newItems = new double[items.length + 1];
            int index = 0;
            for (double item: items) {
                newItems[index] = item;
                index++;
            }
            newItems[newItems.length - 1] = newItem;
            items = newItems;
        }
    }

    public void deleteItem(double deleteItem) {
        if (contains(deleteItem)) {
            double[] newItems = new double[items.length - 1];
            int index = 0;
            for (double item: items) {
                if (item != deleteItem) {
                    newItems[index] = item;
                    index++;
                }
            }
            items = newItems;
        }
    }

    public boolean contains(double newItem) {
        for (double item: items) {
            if (item == newItem) {
                return true;
            }
        }
        return false;
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
