package search;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] words = input.split(" ");
        String key = scanner.nextLine();
        for (int wordsIndex = 0; wordsIndex < words.length; wordsIndex++) {
            if (key.equals(words[wordsIndex])) {
                System.out.println(wordsIndex + 1);
                return;
            }
        }
        System.out.println("Not Found");
    }
}
