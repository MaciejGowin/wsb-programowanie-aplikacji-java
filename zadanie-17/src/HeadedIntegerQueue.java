public abstract class HeadedIntegerQueue implements IntegerQueue {

    protected IntegerNode head;

    public Integer getFirst() {
        if (head != null) {
            Integer value = head.getValue();
            head = head.getNext();
            return value;
        }
        return null;
    }

    public String toString() {
        String values = "";

        IntegerNode current = head;
        while (current != null) {
            if (!values.isEmpty()) {
                values += ", ";
            }
            values += current.getValue();
            current = current.getNext();
        }

        return "[" + values + "]";
    }
}
