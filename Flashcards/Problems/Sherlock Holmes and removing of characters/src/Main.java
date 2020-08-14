import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.nextLine();
        String word2 = scanner.nextLine();

        int count = 0;
        for (int i1 = 0; i1 < word1.length(); i1++) {
            boolean delete = true;
            for (int i2 = 0; i2 < word2.length(); i2++) {
                if (word1.charAt(i1) == word2.charAt(i2)) {
                    delete = false;
                }
            }

            if (delete) {
                count++;
            }
        }

        System.out.println(count);
    }
}