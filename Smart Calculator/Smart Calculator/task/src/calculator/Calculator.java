package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public Calculator() {

    }

    public int calculate(String input) {
        switch(checkError(input)) {
            case 0: break;
            case 1: return Integer.MAX_VALUE;
            case 2: return Integer.MIN_VALUE;
            default: break;
        }

        String simplified = simplifyOperators(input);
        int added = addition(simplified);
        return added;
    }

    private int checkError(String input) {
        if (input.length() == 0) {
            return 1;
        }

        Pattern command = Pattern.compile("/");
        Matcher commandMatcher = command.matcher(input);
        if (commandMatcher.find()) {
            handleArgs(input);
            return 1;
        }

        // The only test not catching is 18 22 becoming 1822
        String errorRegex = "(\\+$|[a-z]|[A-Z]|\\d\\s+\\d|-$)";
        Pattern pattern = Pattern.compile(errorRegex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return 2;
        }

        return 0;
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

    private void handleArgs(String input) {
        if ("/help".equals(input)) {
            System.out.println("The program calculates the sum or difference of numbers");
        } else {
            System.out.println("Unknown command");
        }
    }

    private int addition(String input) {
        String[] additionSplit = input.split("\\+");
        int[] toAdd = new int[additionSplit.length];
        for (int i = 0; i < additionSplit.length; i++) {
            try {
                toAdd[i] = Integer.parseInt(additionSplit[i]);
            } catch(Exception e) {
                if (additionSplit[i].length() > 0) {
                    toAdd[i] = subtraction(additionSplit[i]);
                } else {
                    toAdd[i] = 0;
                }
            }
        }
        int sum = 0;
        for (int num : toAdd) {
            sum += num;
        }
        return sum;
    }

    private int subtraction(String input) {
        boolean hasNegative;
        try {
            hasNegative = "-".equals(input.charAt(0));
        } catch (StringIndexOutOfBoundsException e) {
            return 0;
        }

        String[] subtractionSplit = input.split("-");
        int[] toSubtract = new int[subtractionSplit.length];
        for (int i = 0; i < subtractionSplit.length; i++) {
            try {
                toSubtract[i] = Integer.parseInt(subtractionSplit[i]);
            } catch(Exception e) {
                System.out.println("Error subtraction failed with: " + subtractionSplit[i]);
            }
        }
        int difference = hasNegative ? -toSubtract[0] : toSubtract[0];
        for (int i = 1; i < toSubtract.length; i++) {
            difference -= toSubtract[i];
        }
        return difference;
    }
}
