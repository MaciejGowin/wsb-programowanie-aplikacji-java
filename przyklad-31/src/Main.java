class WithGenericMethods {

    public <T> void nonStaticMethod(T value) {
        System.out.printf("nonStaticMethod: %s: %s%n", value, value.getClass().getName());
    }

    public static <T> void staticMethod(T value) {
        System.out.printf("staticMethod: %s: %s%n", value, value.getClass().getName());
    }
}

public class Main {

    public static void main(String[] args) {
        WithGenericMethods withGenericMethods = new WithGenericMethods();
        withGenericMethods.<String>nonStaticMethod("test");
        withGenericMethods.nonStaticMethod("test");
        withGenericMethods.<Integer>nonStaticMethod(1);
        withGenericMethods.nonStaticMethod(1);

        WithGenericMethods.<String>staticMethod("test");
        WithGenericMethods.staticMethod("test");
        WithGenericMethods.<Integer>staticMethod(1);
        WithGenericMethods.staticMethod(1);
    }
}
