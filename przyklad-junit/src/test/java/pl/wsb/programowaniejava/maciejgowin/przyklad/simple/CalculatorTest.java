package pl.wsb.programowaniejava.maciejgowin.przyklad.simple;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

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