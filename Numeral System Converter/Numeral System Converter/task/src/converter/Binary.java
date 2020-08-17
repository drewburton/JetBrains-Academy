package converter;

import java.util.ArrayList;
import java.util.Collections;

public class Binary extends NumeralSystem {
    public Binary(String number) {
        super(number);
    }

    public Binary(NumeralSystem system) {
        super(system.number);
    }

    @Override
    protected int toDecimal(String number) {
        number = number.substring(2);
        int decimal = 0;
        while (number.length() > 0) {
            int bit = Integer.parseInt(number.charAt(0) + "");
            decimal += bit * Math.pow(2, number.length() - 1);
            number = number.substring(1);
        }
        return decimal;
    }

    @Override
    public String toString() {
        ArrayList<Integer> remainders = new ArrayList<>();
        int nextNumber = number;
        while (nextNumber >= 1) {
            if (nextNumber % 2 == 0) {
                remainders.add(0);
            } else {
                remainders.add(1);
            }
            nextNumber /= 2;
        }
        Collections.reverse(remainders);

        StringBuilder binary = new StringBuilder();
        binary.append("0b");
        if (remainders.size() == 0) {
            binary.append("0");
        }
        for (int num : remainders) {
            binary.append(num);
        }
        return binary.toString();
    }
}
