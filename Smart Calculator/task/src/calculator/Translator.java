package calculator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Translator {
    private String infix;
    private ArrayDeque<String> postfix;

    public Translator(String infix) {
        this.infix = infix;
        translate();
    }

    private void translate() {
        postfix = new ArrayDeque<>();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (Character.isDigit(c)) {
                int v = i + 1;
                while (v < infix.length() && Character.isDigit(infix.charAt(v))) {
                    v++;
                }
                postfix.add(infix.substring(i, v));
                i = v - 1;
            } else if (c == '(') {
                stack.add(c);
            } else if (Character.isAlphabetic(c)) {
                int v = i + 1;
                while (v < infix.length() && !Character.isAlphabetic(infix.charAt(v))
                        && !isOperator(infix.charAt(v))) {
                    v++;
                }
                Integer variable = Main.variables.get(infix.substring(i, v));
                if (variable != null) {
                    postfix.add(variable + "");
                } else {
                    System.out.println("Unknown variable: " + infix.substring(i, v));
                    postfix = null;
                    return;
                }
            } else if (stack.size() == 0 || stack.peekLast() == '(' ||
                    isHigherPrecedence(c, stack.peekLast())) {
                stack.add(c);
            } else if (c == ')') {
                try {
                    do {
                        postfix.add(stack.removeLast() + "");
                    } while (stack.peekLast() != '(');
                } catch (Exception e) {
                    System.out.println("Invalid expression");
                    postfix = null;
                    return;
                }
                stack.removeLast();
            } else if (!isHigherPrecedence(c, stack.peekLast())) {
                    do {
                        postfix.add(stack.removeLast() + "");
                        if (stack.size() == 0) {
                            break;
                        }
                    } while (!isHigherPrecedence(c, stack.peekLast()) || stack.peekLast() != '(');
                stack.add(c);
            } else {
                System.out.println("failure");
            }
        }
        while (stack.size() > 0) {
            var operator = stack.removeLast();
            if (operator == '(' || operator == ')') {
                System.out.println("Invalid expression");
                postfix = null;
                return;
            }
            postfix.add(operator + "");
        }
    }

    private boolean isHigherPrecedence(char operator1, char operator2) {
        return getPrecedence(operator1) > getPrecedence(operator2);
    }

    private int getPrecedence(char operator) {
        switch (operator) {
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }

    public ArrayDeque<String> getPostfix() {
        return postfix;
    }

    private boolean isOperator(char c) {
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

//  Add operands (numbers and variables) to the result (postfix notation) as they arrive.

//  If the stack is empty or contains a left parenthesis on top, push the incoming operator on the stack.
//  If the incoming operator has higher precedence than the top of the stack, push it on the stack.

//  If the incoming operator has lower or equal precedence than the top of the operator stack,
//      pop the stack and add operators to the result until you see an operator that has
//      a smaller precedence or a left parenthesis on the top of the stack; then add the incoming operator to the stack.
//  If the incoming element is a right parenthesis, pop the stack and add operators
//      to the result until you see a left parenthesis. Discard the pair of parentheses.

//  todo: At the end of the expression, pop the stack and add all operators to the result.
