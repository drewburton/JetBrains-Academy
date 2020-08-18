package converter;

public class NumeralSystem {
    private double number;
    private int radix;


    public NumeralSystem(String number, int radix) {
        this.radix = radix;
        String[] parts = number.split("\\.");
        if (parts.length > 1) {
            int integerValue = getIntegerValue(parts[0]);
            double decimalValue = 0;
            for (int i = 0; i < parts[1].length(); i++) {
                decimalValue += letterToNum(parts[1].charAt(i)) / Math.pow(radix, i + 1);
            }
            this.number = integerValue + decimalValue;
        } else {
            this.number = getIntegerValue(number);
        }
    }

    private int getIntegerValue(String number) {
        if (radix == 1) {
            return number.length();
        }
        return Integer.parseInt(number, radix);
    }

    private int letterToNum(char digit) {
        if (Character.isDigit(digit)) {
            return digit - 48;
        } else {
            return Character.toLowerCase(digit) - 'a' + 10;
        }
    }

    public void convert(int newRadix) {
        radix = newRadix;
    }

    @Override
    public String toString() {
        String integerValue;
        if (radix == 1) {
            StringBuilder num = new StringBuilder();
            for (int i = 0; i < (int) number; i++) {
                num.append("1");
            }
            integerValue = num.toString();
        } else {
            integerValue = Integer.toString((int) number, radix);
        }
        double decimalNumber = number - (int) number;
        String decimalString = decimalNumber + "";
        if (decimalString.contains(".")) {
            StringBuilder builder = new StringBuilder();
            builder.append("0.");
            for (int i = 0; i < decimalString.length(); i++) {
                decimalNumber *= radix;
                builder.append(toLetter((int) decimalNumber));
                decimalNumber -= (int) decimalNumber;
            }
            decimalString = builder.toString();
        }
        decimalString = decimalString.substring(1, Math.min(decimalString.length(), 7));
        return integerValue + decimalString;
    }

    private char toLetter(int num) {
        if (num > 9) {
            return (char) (num + 87);
        } else {
            return (char) (num + 48);
        }
    }
}
