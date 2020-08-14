package flashcards;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class IOManager {
    private Map<String, String> cards;
    private Scanner scanner;

    public IOManager() {
        scanner = new Scanner(System.in);
    }

    public void read() {
        System.out.println("Input the number of cards:");
        int num = Integer.parseInt(scanner.nextLine());
        cards = new LinkedHashMap<>();

        for (int i = 1; i <= num; i++) {
            System.out.println("The card #" + i + ":");
            String term = scanner.nextLine();
            while (cards.containsKey(term)) {
                System.out.println("The card \"" + term + "\" already exists. Try again:");
                term = scanner.nextLine();
            }
            System.out.println("The definition of the card #" + i + ":");
            String definition = scanner.nextLine();
            while (cards.containsValue(definition)) {
                System.out.println("The definition \"" + definition + "\" already exists. Try again:");
                definition = scanner.nextLine();
            }
            cards.put(term, definition);
        }
    }

    public void quiz() {
        Scanner scanner = new Scanner(System.in);
        cards.forEach((k, v) -> {
            System.out.println("Print the definition of \"" + k + "\":");
            String answer = scanner.nextLine();
            if (v.equals(answer)) {
                System.out.println("Correct!");
            } else {
                System.out.print("Wrong. The right answer is \"" + v + "\"");
                // check to see if another term has the definition given
                for (String key : cards.keySet()) {
                    if (cards.get(key).equals(answer)) {
                        System.out.print(", but your definition is correct for \"" + key + "\"");
                    }
                }
                System.out.println(".");
            }
        });
    }
}
