package life;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        Universe universe = new Universe(size);
        universe.generateNew();
        universe.runUniverse();
    }


}
