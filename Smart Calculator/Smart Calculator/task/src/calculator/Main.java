package calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (!"/exit".equals(line)) {
            Calculator calculator = new Calculator();
            int answer = calculator.calculate(line);
            if (answer == Integer.MIN_VALUE) {
                System.out.println("Invalid expression");
            } else if (answer != Integer.MAX_VALUE) {
                System.out.println(answer);
            }
            line = scanner.nextLine();
        }
        System.out.println("Bye!");
    }
}
