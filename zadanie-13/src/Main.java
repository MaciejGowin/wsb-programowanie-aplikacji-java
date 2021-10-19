import animal.cat.Cat;
import animal.dog.Dog;

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat("Alfred");
        cat.eat();
        cat.voice();

        Dog dog = new Dog("Diego");
        dog.eat();
        dog.voice();
    }
}
