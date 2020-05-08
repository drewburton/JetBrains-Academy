package calculator;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubtractionCalculator extends SubCalculator {
    public SubtractionCalculator(String input) {
        super(input);
        calculateAnswer();
    }

    @Override
    protected void calculateAnswer() {
        boolean hasNegative;
        try {
            hasNegative = "-".equals(input.charAt(0));
        } catch (StringIndexOutOfBoundsException e) {
            answer = 0;
            return;
        }

        String[] subtractionSplit = input.split("-");
        int[] toSubtract = new int[subtractionSplit.length];
        for (int i = 0; i < subtractionSplit.length; i++) {
            try {
                toSubtract[i] = Integer.parseInt(subtractionSplit[i]);
            } catch(Exception e) {
                if (subtractionSplit[i].length() > 0) {
                    Pattern varPatter = Pattern.compile("([a-z]+|[A-Z]+)");
                    Matcher varMatcher = varPatter.matcher(subtractionSplit[i]);

                    if (varMatcher.matches()) {
                        if (Main.variables.get(subtractionSplit[i]) != null) {
                            toSubtract[i] = Main.variables.get(subtractionSplit[i]);
                            continue;
                        }
                        System.out.println("Unknown variable");
                        answer = null;
                        return;
                    }
                    System.out.println("Error subtraction failed with: " + subtractionSplit[i]);
                    answer = null;
                    return;
                }
            }
        }
        int difference = hasNegative ? -toSubtract[0] : toSubtract[0];
        for (int i = 1; i < toSubtract.length; i++) {
            difference -= toSubtract[i];
        }
        answer = difference;
    }
}
