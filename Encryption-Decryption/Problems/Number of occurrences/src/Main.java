import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String subString = scanner.nextLine();

        System.out.println(containsHowMany(input, subString));
    }

    public static int containsHowMany(String string, String subString) {
        int count = 0;
        for (int i = 0; i < string.length() - subString.length() + 1; i++) {
            if (string.substring(i, i + subString.length()).equals(subString)) {
                count++;
            }
        }
        return count;
    }
}