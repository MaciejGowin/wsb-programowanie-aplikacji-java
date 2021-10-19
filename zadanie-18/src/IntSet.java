class IntNode {

    private int value;
    private IntNode next;

    public IntNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public IntNode getNext() {
        return next;
    }

    public void setNext(IntNode next) {
        this.next = next;
    }
}

public class IntSet {

    private IntNode head;

    public boolean contains(int value) {
        IntNode current = head;
        while (current != null) {
            if (current.getValue() == value) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    public boolean add(int value) {
        if (!contains(value)) {
            IntNode next = new IntNode(value);
            if (head == null) {
                head = next;
            } else {
                next.setNext(head);
                head = next;
            }
            return true;
        }
        return false;
    }

    public boolean remove(int value) {
        IntNode current = head;
        IntNode previous = null;
        while (current != null) {
            if (current.getValue() == value) {
                if (previous != null) {
                    previous.setNext(current.getNext());
                } else {
                    head = current.getNext();
                }
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false;
    }

    public int size() {
        int size = 0;

        IntNode current = head;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    public String toString() {
        String values = "";

        IntNode current = head;
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
