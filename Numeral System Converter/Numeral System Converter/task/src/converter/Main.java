package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String radixString = scanner.hasNextLine() ? scanner.nextLine() : null;
        String numberString = scanner.hasNextLine() ? scanner.nextLine().toLowerCase() : null;
        String newRadixString = scanner.hasNextLine() ? scanner.nextLine() : null;

        if (radixString == null || numberString == null || newRadixString == null) {
            System.out.println("error");
            return;
        } else if (ErrorParser.check(numberString, radixString, newRadixString)) {
            System.out.println("error");
            return;
        }

        int radix = Integer.parseInt(radixString);
        int newRadix = Integer.parseInt(newRadixString);
        NumeralSystem number = new NumeralSystem(numberString, radix);
        number.convert(newRadix);
        System.out.println(number);
    }
}
