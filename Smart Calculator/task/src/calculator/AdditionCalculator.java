package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AdditionCalculator extends SubCalculator {
    public AdditionCalculator(String input) {
        super(input);
        calculateAnswer();
    }

    @Override
    protected void calculateAnswer() {
        String[] additionSplit = input.split("\\+");
        int[] toAdd = new int[additionSplit.length];
        for (int i = 0; i < additionSplit.length; i++) {

            try {
                toAdd[i] = Integer.parseInt(additionSplit[i]);
            } catch(Exception e) {
                if (additionSplit[i].length() > 0) {
                    Pattern varPatter = Pattern.compile("([a-z]+|[A-Z]+)");
                    Matcher varMatcher = varPatter.matcher(input);

                    if (varMatcher.matches()) {
                        if (Main.variables.get(input) != null) {
                            toAdd[i] = Main.variables.get(input);
                            continue;
                        }
                        System.out.println("Unknown variable");
                        return;
                    }
                    toAdd[i] = new SubtractionCalculator(additionSplit[i]).getAnswer();
                    continue;
                }
                toAdd[i] = 0;
            }
        }
        int sum = 0;
        for (int num : toAdd) {
            sum += num;
        }
        answer = sum;
    }
}
