package calculator;

import javax.xml.stream.XMLStreamConstants;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public Calculator() {

    }

    public void calculate(String input) {
        String simplified = simplifyOperators(input);
        ErrorParser parser = new ErrorParser(simplified);

        if (!parser.isCorrectInput()) {
            return;
        }

        Translator translator = new Translator(simplified);
        calculatePostfix(translator.getPostfix());

/*        var addCalc = new AdditionCalculator(simplified);
        Integer answer = addCalc.getAnswer();
        if (answer != null) {
            System.out.println(addCalc.getAnswer() == null ? "" : addCalc.getAnswer());
        }*/
    }

    private String simplifyOperators(String input) {
        String spaceless = input.replaceAll("\\s+", "");
        String singleOperators = spaceless.replaceAll("(\\+\\++|--)", "+");
        String original = "";
        while (!singleOperators.equals(original)) {
            original = singleOperators;
            singleOperators = singleOperators.replaceAll("(\\+\\++|--)", "+");
            singleOperators = singleOperators.replaceAll("(\\+-|-\\+)", "-");
        }
        return singleOperators;
    }

    private void calculatePostfix(ArrayDeque<Character> postfix) {
        if (postfix == null) {
            return;
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        if (postfix.peekFirst() == '8' && postfix.contains('*')) {
           //System.out.println(postfix.toString());
        }
        postfix.forEach(v -> {
            if (Character.isDigit(v)) {
                stack.add(Integer.parseInt(v + ""));
            } else if (!isOperator(v)) {
                stack.add(v - 48);
            } else {
                int num1, num2;
                try {
                    num1 = stack.removeLast();
                    num2 = stack.removeLast();
                } catch(Exception e) {
                    System.out.println(postfix.toString());
                    return;
                }

                switch(v) {
                    case '+': stack.add(num2 + num1);
                        break;
                    case '-': stack.add(num2 - num1);
                        break;
                    case '*': stack.add(num2 * num1);
                        break;
                    case '/': stack.add(num2 / num1);
                        break;
                    default:
                        System.out.println("Invalid expression");
                        return;
                }
            }
        });
        System.out.println(stack.removeLast());
    }

    public static boolean isOperator(char c) {
        switch (c) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
            default:
                return false;
        }
    }
}