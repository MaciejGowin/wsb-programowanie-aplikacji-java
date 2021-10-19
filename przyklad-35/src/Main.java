import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class SampleClass {

    private String privateField;
    public String publicField;

    public SampleClass() {
        System.out.println("Invoked SampleClass()");
    }

    private void privateMethod() {
        System.out.println("Invoked privateMethod()");
    }

    public void publicMethod() {
        System.out.println("Invoked publicMethod()");
    }

    @Override
    public String toString() {
        return String.format("{privateField: %s, privateField: %s}", privateField, publicField);
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        reflectionCreation();
        describeClass(SampleClass.class);
    }

    public static void reflectionCreation() throws Exception {
        // Create instance via reflection
        Constructor<SampleClass> constructor = SampleClass.class.getDeclaredConstructor();
        SampleClass sampleClass = constructor.newInstance();

        // Set fields via reflection
        System.out.printf("sampleClass: %s%n", sampleClass);
        Field publicField = SampleClass.class.getDeclaredField("publicField");
        publicField.set(sampleClass, "value-publicField");

        Field privateField = SampleClass.class.getDeclaredField("privateField");
        privateField.setAccessible(true);
        privateField.set(sampleClass, "value-privateField");

        System.out.printf("sampleClass: %s%n", sampleClass);

        // Invoke methods via reflection
        Method publicMethod = SampleClass.class.getDeclaredMethod("publicMethod");
        publicMethod.invoke(sampleClass);

        Method privateMethod = SampleClass.class.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(sampleClass);
    }

    public static void describeClass(Class<?> clazz) {
        // Get all fields
        System.out.println("Fields:");
        for (Field field: clazz.getDeclaredFields()) {
            System.out.printf(" - %s: %s%n", field.getName(), Modifier.toString(field.getModifiers()));
        }

        // Get all methods
        System.out.println("Methods:");
        for (Method method: clazz.getDeclaredMethods()) {
            System.out.printf(" - %s: %s%n", method.getName(), Modifier.toString(method.getModifiers()));
        }

        // Get all constructors
        System.out.println("Constructors:");
        for (Constructor<?> method: clazz.getDeclaredConstructors()) {
            System.out.printf(" - %s: %s%n", method.getName(), Modifier.toString(method.getModifiers()));
        }
    }
}
