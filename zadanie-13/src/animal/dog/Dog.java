package animal.dog;

import animal.Animal;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    public void voice() {
        System.out.println(getName() + ": barking");
    }
}
