package pl.wsb.programowaniejava.maciejgowin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class GeometricalUtils {

    public static BigDecimal triangleField(BigDecimal a, BigDecimal h) {
        return a.multiply(h).divide(BigDecimal.valueOf(2), new MathContext(2, RoundingMode.HALF_UP));
    }
}
