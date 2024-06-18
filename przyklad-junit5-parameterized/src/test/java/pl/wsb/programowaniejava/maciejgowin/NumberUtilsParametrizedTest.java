package pl.wsb.programowaniejava.maciejgowin;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberUtilsParametrizedTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15})
    void shouldReturnTrueForOddNumbers(int number) {
        assertTrue(NumberUtils.isOdd(number));
    }
}
