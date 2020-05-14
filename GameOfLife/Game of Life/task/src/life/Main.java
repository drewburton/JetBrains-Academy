package life;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();

        generate(n, s);
    }

    public static void generate(int n, int s) {
        Random random = new Random(s);

        for (int c = 0; c < n; c++) {
            for (int r = 0; r < n; r++) {
                boolean b = random.nextBoolean();
                if (b) {
                    System.out.print("O");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
