public class DoubleStack {

    private DoubleStackItem headItem;

    public void push(Double value) {
        DoubleStackItem newItem = new DoubleStackItem(value);

        if (headItem == null) {
            headItem = newItem;
        } else {
            newItem.setNextItem(headItem);
            headItem = newItem;
        }
    }

    public Double pop() {
        if (headItem != null) {
            Double value = headItem.getValue();
            headItem = headItem.getNextItem();
            return value;
        }
        return null;
    }

    public Double peek() {
        if (headItem != null) {
            return headItem.getValue();
        }
        return null;
    }

    public String toString() {
        String stringValue = "";
        DoubleStackItem currentItem = headItem;
        while (currentItem != null) {
            if (!"".equals(stringValue)) {
                stringValue += ", ";
            }
            stringValue += currentItem.getValue();
            currentItem = currentItem.getNextItem();
        }
        return String.format("[%s]", stringValue);
    }
}
