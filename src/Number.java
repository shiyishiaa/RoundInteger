import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Number {
    private final BigInteger integer;
    private final BigDecimal decimal;

    public Number(BigDecimal decimal) {
        this.integer = decimal.toBigInteger();
        this.decimal = decimal.subtract(new BigDecimal(this.integer.toString()));
    }

    public Number(Double d) {
        this(BigDecimal.valueOf(d));
    }

    public static boolean isInteger(BigDecimal bigDecimal) {
        if (bigDecimal.toPlainString().contains("."))
            return bigDecimal.toPlainString().split("\\.")[1].matches("^0+$");
        else
            return true;
    }

    public static BigDecimal square(BigDecimal bigDecimal) {
        return bigDecimal.pow(2);
    }

    public static BigDecimal squareRoot(BigDecimal bigDecimal) {
        return BigDecimal.valueOf(Math.sqrt(bigDecimal.doubleValue()));
    }

    public static BigDecimal minDistanceToInteger(BigDecimal bigDecimal) {
        return bigDecimal.subtract(bigDecimal.setScale(0, RoundingMode.HALF_EVEN)).abs();
    }

    public BigDecimal getDecimal() {
        return decimal;
    }

    public BigInteger getInteger() {
        return integer;
    }

    public void print() {
        System.out.print("Integer Part:");
        System.out.println(integer);
        System.out.print("Decimal Part:");
        System.out.println(decimal);
    }

    public BigDecimal getBigDecimal() {
        return decimal.add(new BigDecimal(integer.toString()));
    }

    public Number add(Number addend) {
        return new Number(this.getBigDecimal().add(addend.getBigDecimal()));
    }

    public Number multiply(Number multiplier) {
        return new Number(this.getBigDecimal().multiply(multiplier.getBigDecimal()));
    }

    @Override
    public String toString() {
        return "Number{" +
                "integer=" + integer +
                ", decimal=" + decimal +
                '}';
    }
}
