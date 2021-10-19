class Container {
    private String value;

    public Container(String value) {
        this.value = value;
    }

    public boolean equals(final Object o) {
        if (o == this)  {
            return true;
        }
        if (!(o instanceof Container)) {
            return false;
        }

        Container other = (Container) o;

        return (this.value == null && other.value == null)
                || (this.value != null && this.value.equals(other.value));
    }
}

public class Main {

    public static void main(String[] args) {
        Container a1 = new Container("test");
        Container a2 = new Container("test");
        Container a3 = new Container("another");
        Container a4 = a1;

        System.out.printf("a1 == a2: %b%n", a1 == a2);
        System.out.printf("a1 == a3: %b%n", a1 == a3);
        System.out.printf("a1 == a4: %b%n", a1 == a4);
        System.out.printf("a1 == null: %b%n", a1 == null);

        System.out.printf("a1 equals a2: %b%n", a1.equals(a2));
        System.out.printf("a1 equals a3: %b%n", a1.equals(a3));
        System.out.printf("a1 equals a4: %b%n", a1.equals(a4));
        System.out.printf("a1 equals null: %b%n", a1.equals(null));
    }
}
