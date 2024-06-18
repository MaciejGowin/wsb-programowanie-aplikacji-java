package pl.wsb.programowaniejava.maciejgowin;

import java.math.BigDecimal;
import java.util.Map;

public class CurrencyConversion {

    private static final Map<String, BigDecimal> CURRENCY_TO_PLN_RATIO = Map.of(
            "USD", BigDecimal.valueOf(4.5123),
            "EUR", BigDecimal.valueOf(4.1989)
    );

    public static BigDecimal convert(BigDecimal priceInPln, String currencyCode) {
        return priceInPln.multiply(CURRENCY_TO_PLN_RATIO.get(currencyCode));
    }
}
