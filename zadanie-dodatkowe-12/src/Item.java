public class Item {

    private String value;
    private int count;
    private Item nextItem;

    public Item(String value) {
        this.value = value;
        this.count = 1;
    }

    public String getValue() {
        return value;
    }

    public Item getNextItem() {
        return nextItem;
    }

    public void increment() {
        count++;
    }

    public void setNextItem(Item nextItem) {
        this.nextItem = nextItem;
    }

    public String toString() {
        return String.format("{%s: %d}", value, count);
    }
}
