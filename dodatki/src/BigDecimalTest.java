import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal v1 = new BigDecimal("21.124");
        BigDecimal v2 = new BigDecimal("1.126");
        List<RoundingMode> modes = List.of(RoundingMode.DOWN, RoundingMode.UP, RoundingMode.HALF_UP, RoundingMode.HALF_DOWN);

        // setScale - rounds to specific number of fields after the decimal point
        System.out.println("Test: setScale");
        modes.forEach(mode -> testSetScale(v1, mode));
        modes.forEach(mode -> testSetScale(v2, mode));

        // round - rounds to specific number of fields counting from integers
        System.out.println("Test: round");
        modes.forEach(mode -> testRound(v1, mode));
        modes.forEach(mode -> testRound(v2, mode));
    }

    private static void testSetScale(BigDecimal value, RoundingMode mode) {
        System.out.printf("setScale for: %s with rounding %s is %s%n", value, mode, value.setScale(2, mode));
    }

    private static void testRound(BigDecimal value, RoundingMode mode) {
        System.out.printf("round for: %s with rounding %s is %s%n", value, mode, value.round(new MathContext(2, mode)));
    }
}
