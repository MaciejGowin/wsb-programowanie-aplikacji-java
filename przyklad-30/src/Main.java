class Container<T> {

    private T data;

    public Container(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }
}

public class Main {

    public static void main(String[] args) {
        Container<String> containerOfString = new Container<String>("value");
        Container<Integer> containerOfInteger = new Container<Integer>(1);

        System.out.println("containerOfString: " + containerOfString.getData());
        System.out.println("containerOfInteger: " + containerOfInteger.getData());
    }
}
