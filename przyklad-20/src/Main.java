class Animal {
    public void voice() {
        System.out.println("Voice");
    }
}

class Dog extends Animal {
    public void voice() {
        System.out.println("Barking");
    }
}

class Cat extends Animal {
}

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.voice();

        Cat cat = new Cat();
        cat.voice();
    }
}
