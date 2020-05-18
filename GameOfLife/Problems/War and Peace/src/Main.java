import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();

        Words words = new Words(input.split(" "));
        words.parseWords();
        words.printWordCount();
    }

    static class Words {
        String[] splitwords;
        ArrayList<String> words;
        ArrayList<Integer> count;

        public Words(String[] splitWords) {
            this.splitwords = splitWords.clone();
            words = new ArrayList<>();
            count = new ArrayList<>(0);
        }

        public void parseWords() {
            for (int i = 0; i < splitwords.length; i++) {
                if (words.contains(splitwords[i])) {
                    int a;
                    for (a = 0; a < words.size(); a++) {
                        if (words.get(a).equals(splitwords[i])) {
                            break;
                        }
                    }
                    count.set(a, count.get(a) + 1);
                } else {
                    words.add(splitwords[i]);
                    count.add(1);
                }
            }
        }

        public void printWordCount() {
            for (int i = 0; i < words.size(); i++) {
                System.out.println(words.get(i) + " " + count.get(i));
            }
        }
    }
}