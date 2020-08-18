package converter;

public class ErrorParser {
    private static String number;
    private static int radix;
    private static int newRadix;

    private ErrorParser() {

    }

    public static boolean check(String number, String radix, String newRadix) {
        ErrorParser.number = number;
        if (radix.matches(".*\\D.*") || newRadix.matches(".*\\D.*")) {
            return true;
        }
        ErrorParser.radix = Integer.parseInt(radix);
        ErrorParser.newRadix = Integer.parseInt(newRadix);

        return checkRadicies() || checkNumber();
    }

    private static boolean checkNumber() {
        if (number.matches("[(?:\\.)|.*\\W.*]")) {
            return true;
        } else if (radix < 11 && number.matches("[(?:\\.)|.*\\D.*]")) {
            return true;
        }

        // 11 has only a, so radix + 86 = a
        char maxLetter = (char) (radix + 86);
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) > maxLetter) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkRadicies() {
        if (radix < 1 || radix > 36 || newRadix < 1 || newRadix > 36) {
            return true;
        }

        return false;
    }
}
