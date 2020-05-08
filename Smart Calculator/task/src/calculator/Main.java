package calculator;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static HashMap<String, Integer> variables;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        variables = new HashMap<>();
        Calculator calculator = new Calculator();
        while (!"/exit".equals(line)) {
            calculator.calculate(line);
            line = scanner.nextLine();
        }
        System.out.println("Bye!");
    }
}
