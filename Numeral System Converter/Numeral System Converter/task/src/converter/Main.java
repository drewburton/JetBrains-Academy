package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimal = Integer.parseInt(scanner.nextLine());
        NumeralSystem decimalNumber = new Decimal(decimal);

        int radix = Integer.parseInt(scanner.nextLine());
        System.out.println(Converter.convert(radix, decimalNumber));
    }
}
