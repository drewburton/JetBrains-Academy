package calculator;

import java.util.HashMap;

public abstract class SubCalculator extends Calculator {
    protected String input;
    protected Integer answer;

    public SubCalculator(String input) {
        this.input = input;
    }

    protected abstract void calculateAnswer();

    public Integer getAnswer() {
        return answer;
    }
}
