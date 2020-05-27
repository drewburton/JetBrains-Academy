import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("password:?\\s*");
        Matcher matcher = pattern.matcher(text.toLowerCase());
        boolean found = false;
        while (matcher.find()) {
            for (int i = matcher.end() + 1; i < text.length(); i++) {
                if (!Character.isAlphabetic(text.charAt(i)) && !Character.isDigit(text.charAt(i))) {
                    found = true;
                    System.out.println(text.substring(matcher.end(), i));
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("No passwords found.");
        }
    }
}