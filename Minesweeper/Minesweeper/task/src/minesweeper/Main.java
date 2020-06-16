package minesweeper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("How many mines do you want on the field?");
        Scanner scanner = new Scanner(System.in);

        Field field = new MineCountField(scanner.nextInt());
        field.print();
    }
}
