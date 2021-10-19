class Animal {
    public void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {
}

class Cat extends Animal {
}

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();

        Cat cat = new Cat();
        cat.eat();
    }
}
