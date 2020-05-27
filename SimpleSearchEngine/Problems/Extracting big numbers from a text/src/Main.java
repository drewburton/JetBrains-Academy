import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stringWithNumbers = scanner.nextLine();

        ArrayList<String> numbers = new ArrayList<>();

        for (int i = 0; i < stringWithNumbers.length(); i++) {
            if (Character.isDigit(stringWithNumbers.charAt(i))) {
                int v = i + 1;
                for (; v < stringWithNumbers.length(); v++) {
                    if (!Character.isDigit(stringWithNumbers.charAt(v))) {
                        break;
                    }
                }
                numbers.add(stringWithNumbers.substring(i, v));
                i = v - 1;
            }
        }

        numbers.forEach(s -> {
            if (s.length() > 10) {
                System.out.println(s + ":" + s.length());
            }
        });
    }
}