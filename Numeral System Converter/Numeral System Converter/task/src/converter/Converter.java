package converter;

public class Converter {
    public enum NumberType { BINARY, DECIMAL, OCTAL, HEXADECIMAL }

    private Converter() {}

    public static NumeralSystem convert(NumberType type, NumeralSystem number) {
        switch(type) {
            case BINARY:
                return new Binary(number);
            case DECIMAL:
                return new Decimal(number);
            case OCTAL:
                return new Octal(number);
            case HEXADECIMAL:
                return new Hexadecimal(number);
        }
        return null;
    }

    public static NumeralSystem convert(int radix, NumeralSystem number) {
        switch(radix) {
            case 2:
                return convert(NumberType.BINARY, number);
            case 8:
                return convert(NumberType.OCTAL, number);
            case 10:
                return convert(NumberType.DECIMAL, number);
            case 16:
                return convert(NumberType.HEXADECIMAL, number);
        }
        return null;
    }
}
