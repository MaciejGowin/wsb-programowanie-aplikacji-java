import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class ClassNoEquals {

    private String value;

    public ClassNoEquals(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

class ClassWithEquals {

    private String value;

    public ClassWithEquals(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ClassWithEquals)) {
            return false;
        }

        ClassWithEquals other = (ClassWithEquals) o;
        return (this.value == null && other.value == null)
                || (this.value != null && this.value.equals(other.value));
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}

public class Main {

    public static void main(String[] args) {
        Set<String> setOfString = new HashSet<>();
        setOfString.add("aaaaa");
        setOfString.add("bbbbb");
        setOfString.add("aaaaa");

        System.out.println(setOfString);

        Set<ClassNoEquals> setOfClassNoEquals = new HashSet<>();
        setOfClassNoEquals.add(new ClassNoEquals("aaaaa"));
        setOfClassNoEquals.add(new ClassNoEquals("bbbbb"));
        setOfClassNoEquals.add(new ClassNoEquals("aaaaa"));

        System.out.println(setOfClassNoEquals);

        Set<ClassWithEquals> setOfClassWithEquals = new HashSet<>();
        setOfClassWithEquals.add(new ClassWithEquals("aaaaa"));
        setOfClassWithEquals.add(new ClassWithEquals("bbbbb"));
        setOfClassWithEquals.add(new ClassWithEquals("aaaaa"));

        System.out.println(setOfClassWithEquals);
    }
}
