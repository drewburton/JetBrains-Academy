package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int radix = Integer.parseInt(scanner.nextLine());
        NumeralSystem number = new NumeralSystem(scanner.nextLine(), radix);
        int newRadix = Integer.parseInt(scanner.nextLine());
        number.convert(newRadix);
        System.out.println(number);
    }
}
