package calculator;

import javax.xml.stream.XMLStreamConstants;
import java.math.BigInteger;
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

    private void calculatePostfix(ArrayDeque<String> postfix) {
        if (postfix == null) {
            return;
        }

        ArrayDeque<BigInteger> stack = new ArrayDeque<>();
        postfix.forEach(v -> {
            try {
                stack.add(new BigInteger(v));
            } catch(Exception e) {
                BigInteger num1, num2;
                try {
                    num1 = stack.removeLast();
                    num2 = stack.removeLast();
                } catch (Exception e2) {
                    System.out.println(postfix.toString());
                    return;
                }

                switch (v) {
                    case "+":
                        stack.add(num2.add(num1));
                        break;
                    case "-":
                        stack.add(num2.subtract(num1));
                        break;
                    case "*":
                        stack.add(num2.multiply(num1));
                        break;
                    case "/":
                        stack.add(num2.divide(num1));
                        break;
                    default:
                        System.out.println("Invalid expression");
                        return;
                }
            }
        });
        System.out.println(stack.removeLast());
    }


}