package pl.wsb.programowaniejava.maciejgowin.junit5.simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Disabled
    @Test
    void shouldEvaluateExpression() {
        // given
        String expression = "2 + 5 + 3";
        int expected = 10;

        // when
        int result = new Calculator().evaluateExpression(expression);

        // then
        assertThat(result)
                .isNotNull()
                .isEqualTo(expected);
    }
}
