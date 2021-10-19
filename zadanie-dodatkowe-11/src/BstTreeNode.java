public class BstTreeNode {

    private Integer value;
    private BstTreeNode leftNode;
    private BstTreeNode rightNode;

    public BstTreeNode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public BstTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BstTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public BstTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BstTreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
