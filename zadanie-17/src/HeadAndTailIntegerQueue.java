public class HeadAndTailIntegerQueue extends HeadedIntegerQueue {

    private IntegerNode tail;

    public void addLast(Integer value) {
        IntegerNode next = new IntegerNode(value);
        if (head == null) {
            head = next;
        }
        if (tail != null) {
            tail.setNext(next);
        }
        tail = next;
    }
}
