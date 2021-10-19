public class Main {

    public static void main(String[] args) {
        BstTree bstTree = new BstTree();
        System.out.printf("Add: %s%n", 8);
        bstTree.add(8);
        System.out.printf("Add: %s%n", 10);
        bstTree.add(10);
        System.out.printf("Add: %s%n", 3);
        bstTree.add(3);
        System.out.printf("Add: %s%n", 6);
        bstTree.add(6);
        System.out.printf("Add: %s%n", 4);
        bstTree.add(4);
        System.out.printf("Min: %s%n", bstTree.getMinValue());
        System.out.printf("Add: %s%n", 14);
        bstTree.add(14);
        System.out.printf("Add: %s%n", 13);
        bstTree.add(13);
        System.out.printf("Add: %s%n", 7);
        bstTree.add(7);
        System.out.printf("Add: %s%n", 1);
        bstTree.add(1);

        System.out.printf("Contains: %s: %s%n", 12, bstTree.contains(10));
        System.out.printf("Contains: %s: %s%n", 2, bstTree.contains(7));
        System.out.printf("Contains: %s: %s%n", 5, bstTree.contains(16));
        System.out.printf("Min: %s%n", bstTree.getMinValue());

        System.out.printf("%nFull tree%n");
        print(bstTree);

        System.out.printf("%nDelete: %s%n", 3);
        bstTree.delete(3);

        System.out.printf("%nFull tree%n");
        print(bstTree);
    }

    private static void print(BstTree bstTree) {
        print(0, bstTree.getRootNode());
    }

    private static void print(int level, BstTreeNode currentNode) {
        if (currentNode != null) {
            if (currentNode.getRightNode() != null) {
                print(level + 1, currentNode.getRightNode());
            }
            System.out.printf("%" + (level > 0 ? 5*level : "") + "s%n", currentNode.getValue());
            if (currentNode.getLeftNode() != null) {
                print(level + 1, currentNode.getLeftNode());
            }
        }
    }
}
