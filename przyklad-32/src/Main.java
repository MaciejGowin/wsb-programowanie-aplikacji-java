public class Main {

    public static void main(String[] args) {
        Container<Cat> catContainer = new Container<>(new Cat());
        Container<Dog> dogContainer = new Container<>(new Dog());
    }

    public static <T> void consume1(Container<T> container) {
        // container.setData(new Dog());
        // container.setData(new Cat());
    }

    public static void consume2(Container<?> container) {
        // container.setData(new Dog());
        // container.setData(new Cat());
    }

    public static <T> void consume3(Container<? extends Animal> container) {
        // container.setData(new Dog());
        // container.setData(new Cat());
    }

    public static <T> void consume4(Container<? super Animal> container) {
        container.setData(new Dog());
        container.setData(new Cat());
    }

    public static void consume5(Container<Animal> container) {
        container.setData(new Dog());
        container.setData(new Cat());
    }

    public static void consume6(Container<Object> container) {
        container.setData(new Dog());
        container.setData(new Cat());
    }
}
