// Posted from EduTools plugin
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();

        String[] firstWords = firstLine.split("(\\s+|\\?+)");
        secondLine = secondLine.replaceAll("\\?", "");

        for (String word : firstWords) {
            secondLine = secondLine.replaceFirst("(\\s" + word + "\\s|\\s" + word + "$|^" + word + "\\s)", " ");
        }

        if (secondLine.replaceAll("\\s+", "").length() > 0) {
            System.out.println("You are busted");
        } else {
            System.out.println("You get money");
        }

    }
}
