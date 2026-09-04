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
            BigInteger gcd = numerator.gcd(denominator);

            BigInteger simplN = numerator.divide(gcd);
            BigInteger simplD = denominator.divide(gcd);

            if (simplD.compareTo(BigInteger.ZERO) < 0) {
                simplN = simplN.negate();
                simplD = simplD.negate();
            }

            this.numerator = simplN;
            this.denominator = simplD;
        }
    }

    public Rational add(Rational other) {
        BigInteger num1 = this.numerator.multiply(other.denominator);
        BigInteger num2 = this.denominator.multiply(other.numerator);

        BigInteger numerator = num1.add(num2);
        BigInteger denominator = this.denominator.multiply(other.denominator);

        return new Rational(numerator, denominator);
    }

    public Rational subtract(Rational other) {
        BigInteger num1 = this.numerator.multiply(other.denominator);
        BigInteger num2 = this.denominator.multiply(other.numerator);

        BigInteger numerator = num1.subtract(num2);
        BigInteger denominator = this.denominator.multiply(other.denominator);

        return new Rational(numerator, denominator);
    }

    public Rational multiply(Rational other) {
        BigInteger numerator = this.numerator.multiply(other.numerator);
        BigInteger denominator = this.denominator.multiply(other.denominator);

        return new Rational(numerator, denominator);
    }

    public Rational divide(Rational other) {
        BigInteger numerator = this.numerator.multiply(other.denominator);
        BigInteger denominator = this.denominator.multiply(other.numerator);

        return new Rational(numerator, denominator);
    }
}