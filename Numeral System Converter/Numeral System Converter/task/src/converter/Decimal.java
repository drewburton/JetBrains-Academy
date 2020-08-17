package converter;

public class Decimal extends NumeralSystem{
    public Decimal(int number) {
        super(number);
    }

    public Decimal(NumeralSystem system) {
        super(system.number);
    }

    @Override
    protected int toDecimal(String number) {
        return Integer.parseInt(number);
    }

    @Override
    public String toString() {
        return number + "";
    }
}
