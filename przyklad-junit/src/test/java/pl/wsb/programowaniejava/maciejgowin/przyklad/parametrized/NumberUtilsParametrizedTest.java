package pl.wsb.programowaniejava.maciejgowin.przyklad.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberUtilsParametrizedTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15})
    void shouldReturnTrueForOddNumbers(int number) {
        assertTrue(NumberUtils.isOdd(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0,2,-18})
    void shouldReturnFalseForEvenNumbers(int number) {
        assertFalse(NumberUtils.isOdd(number));
    }
}
