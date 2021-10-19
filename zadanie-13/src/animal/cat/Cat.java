package animal.cat;

import animal.Animal;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    public void voice() {
        System.out.println(getName() + ": meowing");
    }
}
