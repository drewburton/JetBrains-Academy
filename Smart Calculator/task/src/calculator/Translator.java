package calculator;

public class Translator {
    private String infix;
    private String postfix;

    public Translator(String infix) {
        this.infix = infix;
        postfix = translate();
    }

    private String translate() {

        return infix;
    }

    public String getPostfix() {
        return postfix;
    }
}

//  Add operands (numbers and variables) to the result (postfix notation) as they arrive.
//  If the stack is empty or contains a left parenthesis on top, push the incoming operator on the stack.
//  If the incoming operator has higher precedence than the top of the stack, push it on the stack.
//  If the incoming operator has lower or equal precedence than the top of the operator stack,
//      pop the stack and add operators to the result until you see an operator that has
//      a smaller precedence or a left parenthesis on the top of the stack; then add the incoming operator to the stack.
//  If the incoming element is a left parenthesis, push it on the stack.
//  If the incoming element is a right parenthesis, pop the stack and add operators
//      to the result until you see a left parenthesis. Discard the pair of parentheses.
//  At the end of the expression, pop the stack and add all operators to the result.
