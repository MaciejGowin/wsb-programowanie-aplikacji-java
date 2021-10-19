public class Container {

    private Item headItem;

    public void add(String value) {
        Item existingItem = find(value);
        if (existingItem == null) {
            Item newItem = new Item(value);
            if (headItem == null) {
                headItem = newItem;
            } else {
                Item currentItem = headItem;
                while (currentItem.getNextItem() != null) {
                    currentItem = currentItem.getNextItem();
                }
                currentItem.setNextItem(newItem);
            }
        } else {
            existingItem.increment();
        }
    }

    public Item find(String value) {
        Item currentItem = headItem;
        while (currentItem != null) {
            if (value.equals(currentItem.getValue())) {
                return currentItem;
            }
            currentItem = currentItem.getNextItem();
        }
        return null;
    }

    public String toString() {
        Item currentItem = headItem;
        String result = "";
        while (currentItem != null) {
            if (!"".equals(result)) {
                result += ", ";
            }
            result += currentItem;
            currentItem = currentItem.getNextItem();
        }

        return String.format("[%s]", result);
    }
}
