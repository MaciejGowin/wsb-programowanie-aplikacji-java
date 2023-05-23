package pl.wsb.programowaniejava.maciejgowin.przyklad.parametrized;

import java.math.BigDecimal;
import java.util.Map;

public class CurrencyConversion {

    private static Map<String, BigDecimal> CURRENCY_TO_PLN_RATIO = Map.of(
            "USD", BigDecimal.valueOf(4.5123),
            "EUR", BigDecimal.valueOf(4.1989)
    );

    public static BigDecimal convert(BigDecimal priceInPLN, String currencyCode) {
        return priceInPLN.multiply(CURRENCY_TO_PLN_RATIO.get(currencyCode));
    }
}
