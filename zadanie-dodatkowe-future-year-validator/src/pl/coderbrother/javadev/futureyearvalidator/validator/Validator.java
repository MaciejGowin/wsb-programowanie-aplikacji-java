package pl.coderbrother.javadev.futureyearvalidator.validator;

import java.lang.reflect.Field;
import java.time.Year;

public class Validator {

    public static <T> boolean validate(T object) throws Exception {
        // Find fields annotated
        for (Field field: object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            // Only if field annotated and of String type
            if (field.isAnnotationPresent(FutureYear.class) && Integer.class.equals(field.getType())) {
                // Check value
                Object value = field.get(object);

                // Applicable only to String type
                if (value == null || (Integer) value < Year.now().getValue()) {
                    return false;
                }
            }
        }
        return true;
    }
}
