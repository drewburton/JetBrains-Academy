package editor;

public class Searcher {
    private Searcher() {}

    public static synchronized void startSearch(String text, boolean useRegex) {
        System.out.println("starting search " + (useRegex ? "with" : "without") + " regular expressions");
    }

    public static synchronized void previousMatch() {
        System.out.println("getting previous match");
    }

    public static synchronized void nextMatch() {
        System.out.println("getting next match");
    }
}
