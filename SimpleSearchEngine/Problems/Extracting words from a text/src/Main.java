import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("program");
        Matcher matcher = pattern.matcher(text.toLowerCase());

        while (matcher.find()) {
            System.out.print(matcher.start() + " ");
            for (int i = matcher.start(); i <= text.length(); i++) {
                if (!Character.isAlphabetic(text.charAt(i))) {
                    System.out.print(text.substring(matcher.start(), i) + "\n");
                    break;
                }
            }
        }
    }
}