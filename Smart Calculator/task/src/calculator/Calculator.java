package calculator;

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

        var addCalc = new AdditionCalculator(simplified);
        Integer answer = addCalc.getAnswer();
        if (answer != null) {
            System.out.println(addCalc.getAnswer() == null ? "" : addCalc.getAnswer());
        }
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
}
