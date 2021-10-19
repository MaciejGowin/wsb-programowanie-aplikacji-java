class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Animal animal = new Dog();

        System.out.printf("dog instanceof Dog: %s%n", dog instanceof Dog);
        System.out.printf("dog instanceof Animal: %s%n", dog instanceof Animal);
        System.out.printf("animal instanceof Dog: %s%n", animal instanceof Dog);
        System.out.printf("animal instanceof Animal: %s%n", animal instanceof Animal);
        System.out.printf("animal instanceof Cat: %s%n", animal instanceof Cat);
    }
}
