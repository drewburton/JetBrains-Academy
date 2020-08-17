package converter;

public abstract class NumeralSystem {
    protected int number;

    public NumeralSystem(String number) {
        this.number = toDecimal(number);
    }

    public NumeralSystem(int number) {
        this.number = number;
    }

    protected abstract int toDecimal(String number);

    @Override
    public abstract String toString();
}
