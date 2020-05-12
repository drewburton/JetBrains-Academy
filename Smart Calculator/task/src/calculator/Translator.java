package calculator;

import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Translator {
    private String infix;
    private String postfix;

    public Translator(String infix) {
        this.infix = infix;
        postfix = translate();
    }

    private String translate() {
        ArrayDeque<Integer> numberStack = new ArrayDeque<>();
        ArrayDeque<Character> operatorStack = new ArrayDeque<>();

        for (int i = 0; i < infix.length(); i++) {
            try {
                numberStack.add(Integer.parseInt(infix.charAt(i) + ""));
            } catch(Exception e) {
                Pattern varPatter = Pattern.compile("([a-z]|[A-Z])");
                Matcher varMatcher = varPatter.matcher(infix.charAt(i) + "");

                if (varMatcher.matches()) {
                    int v = i + 1;
                    while (varMatcher.matches() && v != infix.length()) {
                        varPatter.matcher(infix.charAt(v) + "");
                        v++;
                    }
                    if (Main.variables.get(infix.substring(i, v)) != null) {
                        numberStack.add(Main.variables.get(infix.substring(i, v)));
                        continue;
                    }
                    System.out.println("Unknown variable");
                    return "incorrect statement";
                } else if (operatorStack.size() == 0 || operatorStack.peekLast() == '(') {
                    operatorStack.push(infix.charAt(i));
                } else if (infix.charAt(i) == ')') {
                    //#5
                } else if (isHigherPrecedence(infix.charAt(i), operatorStack.peekLast())) {
                    operatorStack.push(infix.charAt(i));
                } else {
                    //#4
                }
            }
        }
        // #6
        return infix;
    }

    private boolean isHigherPrecedence(char operator1, char operator2) {
        return false;
    }

    public String getPostfix() {
        return postfix;
    }
}

//  Add operands (numbers and variables) to the result (postfix notation) as they arrive.
//  If the stack is empty or contains a left parenthesis on top, push the incoming operator on the stack.
//  If the incoming operator has higher precedence than the top of the stack, push it on the stack.
//  todo: If the incoming operator has lower or equal precedence than the top of the operator stack,
//      pop the stack and add operators to the result until you see an operator that has
//      a smaller precedence or a left parenthesis on the top of the stack; then add the incoming operator to the stack.
//  todo: If the incoming element is a right parenthesis, pop the stack and add operators
//      to the result until you see a left parenthesis. Discard the pair of parentheses.
//  todo: At the end of the expression, pop the stack and add all operators to the result.
