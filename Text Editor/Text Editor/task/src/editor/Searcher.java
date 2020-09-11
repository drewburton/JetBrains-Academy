package editor;

import javax.swing.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Searcher {
    private static JTextArea textArea;
    private static String text;
    private static ArrayList<String> occurences;
    private static ArrayList<Integer> occurenceLocations;
    private static int occurenceIndex = 0;

    private Searcher() {

    }

    public static synchronized void startSearch(JTextArea textArea, String keywords, boolean useRegex) {
        Searcher.textArea = textArea;
        Searcher.text = textArea.getText();
        if (text.length() == 0) return;
        System.out.println("starting search " + (useRegex ? "with" : "without") + " regular expressions");

         occurences = new ArrayList<>();
         occurenceLocations = new ArrayList<>();
         occurenceIndex = 0;

        if (useRegex) {
            Pattern pattern = Pattern.compile(keywords);
            Matcher matcher = pattern.matcher(text);
            matcher.results().forEachOrdered(matchResult -> {
                occurenceLocations.add(matchResult.start());
                occurences.add(matchResult.group());
            });
            System.out.println("Found " + occurences.size() + " items using: " + keywords);
            occurences.forEach(System.out::println);
            System.out.println("at:");
            occurenceLocations.forEach(System.out::println);
        } else {
            int index = text.indexOf(keywords);
            System.out.println("First index: " + index);
            while (index != -1 && index < text.length()) {
                occurenceLocations.add(index);
                occurences.add(text.substring(index, index + keywords.length()));
                index = text.indexOf(keywords, index + keywords.length());
                System.out.println(index);
            }
        }

        selectText();
    }

    public static synchronized void previousMatch() {
        if (occurences != null) {
            System.out.println("getting previous match");

            if (occurenceIndex == 0)
                occurenceIndex = occurences.size() - 1;
            else
                occurenceIndex--;

            selectText();
        }
    }

    public static synchronized void nextMatch() {
        if (occurences != null) {
            System.out.println("getting next match");

            if (occurenceIndex == occurences.size() - 1)
                occurenceIndex = 0;
            else
                occurenceIndex++;

            selectText();
        }
    }

    private static void selectText() {
        if (occurenceLocations.size() > 0) {
            int startIndex = occurenceLocations.get(occurenceIndex);
            int endIndex = startIndex + occurences.get(occurenceIndex).length();
            textArea.setCaretPosition(endIndex);
            textArea.select(startIndex, endIndex);
            textArea.grabFocus();
        }
    }
}
