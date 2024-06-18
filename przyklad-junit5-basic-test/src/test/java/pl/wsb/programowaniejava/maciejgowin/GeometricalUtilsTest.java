package pl.wsb.programowaniejava.maciejgowin;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeometricalUtilsTest {

    @Test
    void shouldCalculateTriangleField() {
        // given
        BigDecimal a = valueOf(10L);
        BigDecimal h = valueOf(5L);

        // when
        BigDecimal result = GeometricalUtils.triangleField(a, h);

        // then
        assertEquals(valueOf(25L), result);
    }
}
