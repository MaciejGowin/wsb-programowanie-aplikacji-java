interface Animal {
    void eat();
}

interface Mammal extends Animal {
    void breath();
}

interface Nameable {
    String getName();
}

abstract class Pet implements Mammal, Nameable {

    private String name;

    public Pet(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println("Eating");
    }

    public void breath() {
        System.out.println("Breathing");
    }

    public abstract void voice();

    public String getName() {
        return name;
    }
}

class Dog extends Pet {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void voice() {
        System.out.println("Bark");
    }
}

class Cat extends Pet {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void voice() {
        System.out.println("Miau");
    }
}

public class Main {

    public static void main(String[] args) {
        Dog arnold = new Dog("Arnold");
        arnold.breath();
        arnold.voice();

        Mammal antonio = new Dog("Antoion");
        antonio.breath();
    }
}
