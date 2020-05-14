package calculator;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ErrorParser extends Calculator {
    private String input;
    private boolean correctInput;

    public ErrorParser(String input) {
        this.input = input;

        correctInput = checkError() && checkVariables() && checkArgs();
    }

    public boolean isCorrectInput() {
        return correctInput;
    }

    private boolean checkArgs() {
        Pattern command = Pattern.compile("^/");
        Matcher commandMatcher = command.matcher(input);
        if (!commandMatcher.find()) {
            return true;
        }

        if ("/help".equals(input)) {
            System.out.println("The program calculates the sum or difference of numbers");
            return true;
        } else {
            System.out.println("Unknown command");
            return false;
        }
    }

    private boolean checkError() {
        if (input.length() == 0) {
            return false;
        }

        String errorRegex = "(\\+$|\\d\\s+\\d|-$)";
        Pattern pattern = Pattern.compile(errorRegex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            System.out.println("Invalid expression");
            return false;
        }

        return true;
    }

    private boolean checkVariables() {
        if (input.contains("=")) {

            // check for multiple equal signs
            String regex = "(=.*=|=.*([a-z]|[A-Z])+\\d|=.*\\d([a-z]|[A-Z]))";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                System.out.println("Invalid assignment");
                return false;
            }

            // check for numbers in the variable you are creating
            regex = "\\d.*=";
            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(input);
            if (matcher.find()) {
                System.out.println("Invalid identifier");
                return false;
            }

            // try assigning and if it fails, check to see if value wasn't given
            // or if it is being assigned to a variable. If the variable isn't
            // found, then the assignment isn't valid, otherwise set the value
            // of the new variable to the value found at the other one
            String[] assignment = input.split("=");
            try {
                Main.variables.put(assignment[0], Integer.parseInt(assignment[1]));
                return false;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid assignment");
                return false;
            } catch(Exception e) {
                Integer setter = Main.variables.get(assignment[1]);

                if (setter == null) {
                    System.out.println("Unknown variable");
                    return false;
                }

                Main.variables.put(assignment[0], setter);
                return false;
            }
        }
        return true;
    }
}
