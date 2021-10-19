public class BstTree {

    private BstTreeNode rootNode;

    public BstTreeNode getRootNode() {
        return rootNode;
    }

    public Integer getMinValue() {
        return getMinValue(rootNode);
    }

    public boolean contains(Integer searchedValue) {
        BstTreeNode currentNode = rootNode;
        while (currentNode != null) {
            if (searchedValue.equals(currentNode.getValue())) {
                return true;
            }
            if (searchedValue < currentNode.getValue()) {
                currentNode = currentNode.getLeftNode();
            } else {
                currentNode = currentNode.getRightNode();
            }
        }
        return false;
    }

    public void add(final Integer value) {
        BstTreeNode newNode = new BstTreeNode(value);
        if (rootNode == null) {
            rootNode = newNode;
        } else {
            BstTreeNode currentNode = rootNode;
            while (true) {
                if (value < currentNode.getValue()) {
                    if (currentNode.getLeftNode() == null) {
                        currentNode.setLeftNode(newNode);
                        break;
                    } else {
                        currentNode = currentNode.getLeftNode();
                    }
                } else {
                    if (currentNode.getRightNode() == null) {
                        currentNode.setRightNode(newNode);
                        break;
                    } else {
                        currentNode = currentNode.getRightNode();
                    }
                }
            }
        }
    }

    public void delete(Integer value) {
        rootNode = delete(rootNode, value);
    }

    private static Integer getMinValue(final BstTreeNode rootNode) {
        if (rootNode != null) {
            BstTreeNode currentRootNode = rootNode;
            while (currentRootNode.getLeftNode() != null) {
                currentRootNode = currentRootNode.getLeftNode();
            }
            return currentRootNode.getValue();
        }
        return null;
    }

    private static BstTreeNode delete(BstTreeNode currentRootNode, Integer value) {
        if (currentRootNode == null) {
            return null;
        }

        if (value < currentRootNode.getValue()) {
            currentRootNode.setLeftNode(delete(currentRootNode.getLeftNode(), value));
        } else if (value > currentRootNode.getValue()) {
            currentRootNode.setRightNode(delete(currentRootNode.getRightNode(), value));
        } else {
            if (currentRootNode.getLeftNode() == null) {
                return currentRootNode.getRightNode();
            }
            else if (currentRootNode.getRightNode() == null) {
                return currentRootNode.getLeftNode();
            }

            currentRootNode.setValue(getMinValue(currentRootNode.getRightNode()));
            currentRootNode.setRightNode(delete(currentRootNode.getRightNode(), currentRootNode.getValue()));
        }

        return currentRootNode;
    }
}
