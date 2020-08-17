package converter;

public class NumeralSystem {
    private int number;
    private int radix;


    public NumeralSystem(String number, int radix) {
        if (radix == 1) {
            this.number = number.length();
        } else {
            this.number = Integer.parseInt(number, radix);
        }
        this.radix = radix;
    }

    public void convert(int newRadix) {
        radix = newRadix;
    }

    @Override
    public String toString() {
        if (radix == 1) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < number; i++) {
                builder.append("1");
            }
            return builder.toString();
        }
        return Integer.toString(number, radix);
    }
}
