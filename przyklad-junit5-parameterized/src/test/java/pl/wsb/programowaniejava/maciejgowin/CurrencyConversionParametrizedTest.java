package pl.wsb.programowaniejava.maciejgowin;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrencyConversionParametrizedTest {

    private static Stream<Arguments> shouldCalculatePriceInGivenCurrency() {
        return Stream.of(
                Arguments.of(BigDecimal.valueOf(10), "USD", BigDecimal.valueOf(45.123)),
                Arguments.of(BigDecimal.valueOf(10.34), "EUR", BigDecimal.valueOf(43.416626)));
    }

    @ParameterizedTest
    @MethodSource
    void shouldCalculatePriceInGivenCurrency(BigDecimal value, String currencyCode, BigDecimal expected) {
        BigDecimal actual = CurrencyConversion.convertToPln(value, currencyCode);
        assertThat(actual.doubleValue()).isEqualTo(expected.doubleValue());
    }
}
