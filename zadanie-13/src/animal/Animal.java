package animal;

public class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(getName() + ": eating");
    }

    public void voice() {
        System.out.println(getName() + ": honking");
    }

    public String getName() {
        return name;
    }
}
