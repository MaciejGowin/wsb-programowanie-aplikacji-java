package pl.wsb.programowaniejava.maciejgowin;

import java.math.BigDecimal;
import java.util.Map;

public class CurrencyConversion {

    private static final Map<String, BigDecimal> CURRENCY_PLN_RATIO = Map.of(
            "USD", BigDecimal.valueOf(4.5123),
            "EUR", BigDecimal.valueOf(4.1989)
    );

    public static BigDecimal convertToPln(BigDecimal value, String currencyCode) {
        return value.multiply(CURRENCY_PLN_RATIO.get(currencyCode));
    }
}
