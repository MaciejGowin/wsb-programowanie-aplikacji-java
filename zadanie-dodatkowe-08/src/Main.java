public class Main {

    public static void main(String[] args) {
        DoubleStack doubleStack = new DoubleStack();
        doubleStack.push(1.0);
        doubleStack.push(2.0);
        doubleStack.push(3.0);

        System.out.println("Stack: " + doubleStack);
        System.out.println("Peek: " + doubleStack.peek());
        System.out.println("Stack: " + doubleStack);
        System.out.println("Pop: " + doubleStack.pop());
        System.out.println("Stack: " + doubleStack);
        System.out.println("Pop: " + doubleStack.pop());
        System.out.println("Stack: " + doubleStack);
        System.out.println("Pop: " + doubleStack.pop());
        System.out.println("Stack: " + doubleStack);
        System.out.println("Pop: " + doubleStack.pop());
        System.out.println("Stack: " + doubleStack);
    }
}
