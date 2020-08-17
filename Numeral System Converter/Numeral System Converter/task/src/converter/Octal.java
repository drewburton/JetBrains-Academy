package converter;

import java.util.ArrayList;
import java.util.Collections;

public class Octal extends NumeralSystem {
    public Octal(String number) {
        super (number);
    }

    public Octal(NumeralSystem system) {
        super(system.number);
    }

    @Override
    protected int toDecimal(String number) {
        number = number.substring(1);
        int decimal = 0;
        while (number.length() > 0) {
            int digit = Integer.parseInt(number.charAt(0) + "");
            decimal += digit * Math.pow(8, number.length() - 1);
            number = number.substring(1);
        }
        return decimal;
    }

    @Override
    public String toString() {
        ArrayList<Integer> remainders = new ArrayList<>();
        int nextNumber = number;
        while (nextNumber >= 1) {
            remainders.add((int) (((nextNumber / 8.0) - (nextNumber / 8)) * 8));
            nextNumber /= 8;
        }
        Collections.reverse(remainders);

        StringBuilder octal = new StringBuilder();
        octal.append("0");
        if (remainders.size() == 0) {
            octal.append("0");
        }
        for (int num : remainders) {
            octal.append(num);
        }
        return octal.toString();
    }
}
