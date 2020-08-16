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
        Saver.println("The card:");
        String term = Saver.nextLine(scanner);
        if (cards.containsKey(term)) {
            Saver.println("The card \"" + term + "\" already exists.");
            return;
        }

        Saver.println("The definition of the card:");
        String definition = Saver.nextLine(scanner);
        if (cards.containsValue(definition)) {
            Saver.println("The definition \"" + definition + "\" already exists.");
            return;
        }
        cards.put(term, definition);
        Saver.println("The pair (\"" + term + "\":\"" + definition + "\") has been added.\n");
    }

    public void remove() {
        Saver.println("The card:");
        String term = Saver.nextLine(scanner);
        if (cards.containsKey(term)) {
            cards.remove(term);
            StatsManager.remove(term);
            Saver.println("The card has been removed.");
        } else {
            Saver.println("Can't remove \"" + term + "\": there is no such card.\n");
        }
    }

    public void ask() {
        Saver.println("How many times to ask?");
        int times = Integer.parseInt(Saver.nextLine(scanner));
        Iterator<String> iterator = (new HashSet<>(cards.keySet())).iterator();
        ask(times, iterator);
        Saver.println("");
    }

    private void ask(int times, Iterator<String> iterator) {
        if (!iterator.hasNext()) {
            iterator = (new HashSet<>(cards.keySet())).iterator();
        }
        String term = iterator.next();
        Saver.println("Print the definition of \"" + term + "\":");
        String answer = Saver.nextLine(scanner);
        String definition = cards.get(term);
        if (answer.equals(definition)) {
            Saver.println("Correct!");
        } else {
            StatsManager.addMistake(term);

            StringBuilder print = new StringBuilder();
            print.append("Wrong. The right answer is \"" + definition + "\"");

            for (String key : cards.keySet()) {
                if (cards.get(key).equals(answer)) {
                    print.append(", but your definition is correct for \"" + key + "\"");
                }
            }
            print.append(".");
            Saver.println(print.toString());
        }

        times--;
        if (times != 0) {
            ask(times, iterator);
        }
    }
}
