import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int max = -1;
        for (; n > 0; n--) {
            int next = Integer.parseInt(scanner.nextLine());
            if (next % 4 == 0 && next > max) {
                max = next;
            }
        }
        System.out.println(max);
    }
}