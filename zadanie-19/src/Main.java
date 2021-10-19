class Container<T> {
    private T data;

    public Container(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public String toString() {
        return String.format("Container: (%s)", data);
    }
}

class Pair<T, U> {
    private T left;
    private U right;

    public Pair(T left, U right) {
        this.left = left;
        this.right = right;
    }

    public String toString() {
        return String.format("Pair: (%s, %s)", left, right);
    }
}

public class Main {

    public static void main(String[] args) {
        Pair<Integer, String> simplePair
                = new Pair<>(1, "value");
        Pair<Container<Integer>, Container<String>> complexPair
                = new Pair<>(new Container<>(1), new Container<>("value"));

        System.out.printf("simplePair: %s%n", simplePair.toString());
        System.out.printf("complexPair: %s%n", complexPair.toString());
    }
}
