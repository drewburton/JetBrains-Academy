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
