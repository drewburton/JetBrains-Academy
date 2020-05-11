package calculator;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// all expressions 3 + 8 * ((4 + 3) * 2 + 1) - 6 / (2 + 1) = 121

//  If the incoming element is a number, push it into the stack (the whole number, not a single digit!).
//  If the incoming element is the name of a variable, push its value into the stack.
//  If the incoming element is an operator, then pop twice to get two numbers and perform the operation;
//      push the result on the stack.
//  When the expression ends, the number on the top of the stack is a final result.

public class Calculator {

    static HashMap<String, Integer> variables;

    public Calculator() {
        variables = new HashMap<>();
    }

    public void calculate(String input) {
        String simplified = simplifyOperators(input);
        if (checkError(simplified)) {
            return;
        } else if (checkVariables(simplified)) {
            return;
        }

        Translator translator = new Translator(simplified);

        int added = addition(simplified);
        System.out.println(added);
    }

    private boolean checkError(String input) {
        if (input.length() == 0) {
            return true;
        }

        Pattern command = Pattern.compile("/");
        Matcher commandMatcher = command.matcher(input);
        if (commandMatcher.find()) {
            handleArgs(input);
            return true;
        }

        String errorRegex = "(\\+$|\\d\\s+\\d|-$)";
        Pattern pattern = Pattern.compile(errorRegex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            System.out.println("Invalid expression");
            return true;
        }

        return false;
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

    private boolean checkVariables(String input) {
        if (input.contains("=")) {
            if (checkVariableErrors(input)) {
                return true;
            }

            // try assigning and if it fails, check to see if value wasn't given
            // or if it is being assigned to a variable. If the variable isn't
            // found, then the assignment isn't valid, otherwise set the value
            // of the new variable to the value found at the other one
            String[] assignment = input.split("=");
            try {
                variables.put(assignment[0], Integer.parseInt(assignment[1]));
                return true;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid assignment");
                return true;
            } catch(Exception e) {
                Integer setter = variables.get(assignment[1]);

                if (setter == null) {
                    System.out.println("Unknown variable");
                    return true;
                }

                variables.put(assignment[0], setter);
                return true;
            }
        }
        Pattern variableDetection = Pattern.compile("([a-z]|[A-Z])");
        Matcher matcher = variableDetection.matcher(input);
        if (matcher.find()) {
            Integer retrieved = variables.get(input);
            if (retrieved == null) {
                System.out.println("Unknown variable");
                return true;
            }
            System.out.println(retrieved);
            return true;
        }
        return false;
    }

    private boolean checkVariableErrors(String input) {
        // check for numbers in the variable you are creating
        String regex = "\\d.*=";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            System.out.println("Invalid identifier");
            return true;
        }

        // check for multiple equal signs
        regex = "=.*=";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(input);
        if (matcher.find()) {
            System.out.println("Invalid assignment");
            return true;
        }
        return false;
    }
}
