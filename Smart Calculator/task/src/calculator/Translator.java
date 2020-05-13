package calculator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Translator {
    private String infix;
    private ArrayDeque<Character> postfix;

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

            }
        }
    }

    private boolean isHigherPrecedence(char operator1, char operator2) {
        return false;
    }

    public ArrayDeque<Character> getPostfix() {
        return postfix;
    }
}

//  todo: Add operands (numbers and variables) to the result (postfix notation) as they arrive.
//  todo: If the stack is empty or contains a left parenthesis on top, push the incoming operator on the stack.
//  todo: If the incoming operator has higher precedence than the top of the stack, push it on the stack.
//  todo: If the incoming operator has lower or equal precedence than the top of the operator stack,
//      pop the stack and add operators to the result until you see an operator that has
//      a smaller precedence or a left parenthesis on the top of the stack; then add the incoming operator to the stack.
//  todo: If the incoming element is a right parenthesis, pop the stack and add operators
//      to the result until you see a left parenthesis. Discard the pair of parentheses.
//  todo: At the end of the expression, pop the stack and add all operators to the result.
