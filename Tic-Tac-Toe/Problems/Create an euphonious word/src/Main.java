import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();

        int count = 0;
        int inARow = 1;
        char previous = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            if ((isVowel(c) && !isVowel(previous)) || (!isVowel(c) && isVowel(previous))) {
                count += getNumberToInsert(inARow);
                inARow = 1;
            } else {
                inARow++;
            }
            previous = c;
        }
        if (inARow >= 3) {
            count += getNumberToInsert(inARow);
        }
        System.out.println(count);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' ||
                c == 'o' || c == 'u' || c == 'y';
    }

    private static long getNumberToInsert(int n) {
        return Math.round((n / 2.0) - 1);
    }
}