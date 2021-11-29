import java.lang.reflect.Field;
import java.util.Objects;

public class FieldEqualsValidator {

    public static boolean validate(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        if (clazz.isAnnotationPresent(FieldEquals.class)) {
            FieldEquals fieldEquals = clazz.getDeclaredAnnotation(FieldEquals.class);

            Object firstValue = null;
            Object secondValue = null;

            for (Field field: clazz.getDeclaredFields()) {
                // If first
                if (field.getName().equals(fieldEquals.firstField())) {
                    field.setAccessible(true);
                    firstValue = field.get(object);
                }
                // If second
                if (field.getName().equals(fieldEquals.secondField())) {
                    field.setAccessible(true);
                    secondValue = field.get(object);
                }
            }

            // Compare
            return Objects.equals(firstValue, secondValue);
        }

        return true;
    }
}
