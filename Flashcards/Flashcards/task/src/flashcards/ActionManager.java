package flashcards;

import java.util.*;

public class ActionManager {
    private Map<String, String> cards;
    private Scanner scanner;

    public ActionManager(Scanner scanner) {
        cards = new HashMap<>();
        this.scanner = scanner;
    }

    public Map<String, String> getCards() {
        return cards;
    }

    public void setCards(Map<String, String> cards) {
        cards.forEach((k, v) -> this.cards.put(k, v));
    }

    public void add() {
        System.out.println("The card:");
        String term = scanner.nextLine();
        if (cards.containsKey(term)) {
            System.out.println("The card \"" + term + "\" already exists.");
            return;
        }

        System.out.println("The definition of the card:");
        String definition = scanner.nextLine();
        if (cards.containsValue(definition)) {
            System.out.println("The definition \"" + definition + "\" already exists.");
            return;
        }
        cards.put(term, definition);
        System.out.println("The pair (\"" + term + "\":\"" + definition + "\") has been added.");
    }

    public void remove() {
        System.out.println("The card:");
        String term = scanner.nextLine();
        if (cards.containsKey(term)) {
            cards.remove(term);
            System.out.println("The card has been removed.");
        } else {
            System.out.println("Can't remove \"" + term + "\": there is no such card.");
        }
    }

    public void ask() {
        System.out.println("How many times to ask?");
        int times = Integer.parseInt(scanner.nextLine());
        Iterator<String> iterator = (new HashSet<>(cards.keySet())).iterator();
        ask(times, iterator);
    }

    private void ask(int times, Iterator<String> iterator) {
        if (!iterator.hasNext()) {
            iterator = (new HashSet<>(cards.keySet())).iterator();
        }
        String term = iterator.next();
        System.out.println("Print the definition of \"" + term + "\":");
        String answer = scanner.nextLine();
        String definition = cards.get(term);
        if (answer.equals(definition)) {
            System.out.println("Correct!");
        } else {
            System.out.print("Wrong. The right answer is \"" + definition + "\"");

            for (String key : cards.keySet()) {
                if (cards.get(key).equals(answer)) {
                    System.out.print(", but your definition is correct for \"" + key + "\"");
                }
            }
            System.out.println(".");
        }

        times--;
        if (times != 0) {
            ask(times, iterator);
        }
    }
}
