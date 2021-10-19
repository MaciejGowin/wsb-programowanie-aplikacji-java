public class IntegerNode {

    private Integer value;
    private IntegerNode next;

    public IntegerNode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public IntegerNode getNext() {
        return next;
    }

    public void setNext(IntegerNode next) {
        this.next = next;
    }
}
