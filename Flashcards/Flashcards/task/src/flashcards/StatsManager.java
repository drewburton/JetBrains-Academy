package flashcards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StatsManager {
    private static HashMap<String, Integer> mistakes;
    private Scanner scanner;

    public StatsManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public String hardestCard() {
        if (mistakes == null || mistakes.size() == 0) {
            Saver.println("There are no cards with errors\n");
        } else {
            ArrayList<String> hardest = new ArrayList<>();
            int highestMistakes = 0;
            for (String key : mistakes.keySet()) {
                int mistakeCount = mistakes.get(key);
                if (mistakeCount > highestMistakes) {
                    highestMistakes = mistakeCount;
                    hardest = new ArrayList<>();
                    hardest.add(key);
                } else if (mistakeCount == highestMistakes) {
                    hardest.add(key);
                }
            }

            StringBuilder message = new StringBuilder();
            if (hardest.size() == 1) {
                message.append("The hardest card is ");
            } else {
                message.append("The hardest cards are ");
            }

            int mistake = 0;
            for (String key : hardest) {
                message.append("\"" + key + "\", ");
                mistake = mistakes.get(key);
            }
            message.replace(message.length() - 2, message.length(), ". ");
            message.append("You have " + mistake + " errors answering ");

            if (hardest.size() == 1) {
                message.append("it.\n");
            } else {
                message.append("them.\n");
            }
            Saver.println(message.toString());
        }
        return null;
    }

    public void resetStats() {
        mistakes = new HashMap<>();
        Saver.println("Card statistics has been reset");
    }

    public static void addMistake(String key) {
        if (mistakes == null) {
            mistakes = new HashMap<>();
            mistakes.put(key, 1);
        } else if (mistakes.containsKey(key)) {
            mistakes.put(key, mistakes.get(key) + 1);
        } else {
            mistakes.put(key, 1);
        }
    }

    public static void addMistake(String key, int mistakesCount) {
        if (mistakes == null) {
            mistakes = new HashMap<>();
            mistakes.put(key, mistakesCount);
        } else if (mistakes.containsKey(key)) {
            mistakes.put(key, mistakesCount);
        } else {
            mistakes.put(key, mistakesCount);
        }
    }

    public static void remove(String key) {
        mistakes.remove(key);
    }

    public static int getMistakes(String key) {
        return mistakes.get(key);
    }
}
