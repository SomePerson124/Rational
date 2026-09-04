import java.math.BigInteger;
import java.util.Objects;

public class Rational extends Number implements Comparable<Rational> {

    private final BigInteger numerator, denominator;

    public Rational (long numerator) {
        this(BigInteger.valueOf(numerator), BigInteger.ONE);
    }

    public Rational (BigInteger numerator, BigInteger denominator) {
        Objects.requireNonNull(numerator, "numerator can't be null");
        Objects.requireNonNull(denominator, "denominator can't be null");
        if (denominator.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("denominator can't be zero");
        }
        if (numerator.equals(BigInteger.ZERO)) {
            this.numerator = BigInteger.ZERO;
            this.denominator = BigInteger.ONE;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

}