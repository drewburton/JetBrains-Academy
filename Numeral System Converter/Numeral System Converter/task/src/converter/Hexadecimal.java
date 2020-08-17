package converter;

import java.util.ArrayList;
import java.util.Collections;

public class Hexadecimal extends NumeralSystem{
    public Hexadecimal(String number) {
        super (number);
    }

    public Hexadecimal(NumeralSystem system) {
        super(system.number);
    }

    @Override
    protected int toDecimal(String number) {
        number = number.substring(2);
        int decimal = 0;
        while (number.length() > 0) {
            int digit = hexDigitToDecimal(number.charAt(0));
            decimal += digit * Math.pow(16, number.length() - 1);
            number = number.substring(1);
        }
        return decimal;
    }

    private int hexDigitToDecimal(char digit) {
        switch(Character.toLowerCase(digit)) {
            case 'a': return 10;
            case 'b': return 11;
            case 'c': return 12;
            case 'd': return 13;
            case 'e': return 14;
            case 'f': return 15;
            default:
                return Integer.parseInt(digit + "");
        }
    }

    @Override
    public String toString() {
        ArrayList<Integer> remainders = new ArrayList<>();
        int nextNumber = number;
        while (nextNumber >= 1) {
            remainders.add((int) (((nextNumber / 16.0) - (nextNumber / 16)) * 16));
            nextNumber /= 16;
        }
        Collections.reverse(remainders);

        StringBuilder hex = new StringBuilder();
        hex.append("0x");
        if (remainders.size() == 0) {
            hex.append("0");
        }
        for (int num : remainders) {
            hex.append(decimalDigitToHex(num));
        }
        return hex.toString();
    }

    private String decimalDigitToHex(int digit) {
        switch (digit) {
            case 10: return "a";
            case 11: return "b";
            case 12: return "c";
            case 13: return "d";
            case 14: return "e";
            case 15: return "f";
            default: return digit + "";
        }
    }
}
