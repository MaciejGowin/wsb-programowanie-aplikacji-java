package pl.wsb.programowaniejava.maciejgowin.przyklad.parametrized;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberUtilsTest {

    @ValueSource(ints = {1, 3, 5, -3, 15})

    @Test
    void shouldReturnTrueFor1() {
        assertTrue(NumberUtils.isOdd(1));
    }

    @Test
    void shouldReturnTrueFor3() {
        assertTrue(NumberUtils.isOdd(3));
    }

    @Test
    void shouldReturnTrueFor5() {
        assertTrue(NumberUtils.isOdd(5));
    }

    @Test
    void shouldReturnTrueForNegative3() {
        assertTrue(NumberUtils.isOdd(-3));
    }

    @Test
    void shouldReturnTrueFor15() {
        assertTrue(NumberUtils.isOdd(15));
    }
    @Test
    void shouldReturnFalseFor0() {
        assertFalse(NumberUtils.isOdd(0));
    }
    @Test
    void shouldReturnFalseFor2() {
        assertFalse(NumberUtils.isOdd(2));
    }
    @Test
    void shouldReturnFalseForNegative18() {
        assertFalse(NumberUtils.isOdd(-18));
    }
}
