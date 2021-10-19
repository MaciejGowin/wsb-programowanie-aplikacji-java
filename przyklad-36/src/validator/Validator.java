package validator;

import java.lang.reflect.Field;

public class Validator {

    public static <T> boolean validate(T object) throws Exception {
        // Find fields annotated
        for (Field field: object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            // Only if field annotated and of String type
            if (field.isAnnotationPresent(NotEmpty.class) && String.class.equals(field.getType())) {
                // Check value
                Object value = field.get(object);

                // Applicable only to String type
                if (value == null || value.toString().length() == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
