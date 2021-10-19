public class DoubleStackItem {

    private Double value;
    private DoubleStackItem nextItem;

    public DoubleStackItem(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public DoubleStackItem getNextItem() {
        return nextItem;
    }

    public void setNextItem(DoubleStackItem nextItem) {
        this.nextItem = nextItem;
    }
}
