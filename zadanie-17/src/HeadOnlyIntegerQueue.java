public class HeadOnlyIntegerQueue extends HeadedIntegerQueue {

    public void addLast(Integer value) {
        IntegerNode next = new IntegerNode(value);
        if (head == null) {
            head = next;
        } else {
            IntegerNode last = head;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(next);
        }
    }
}
