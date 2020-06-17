package minesweeper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("How many mines do you want on the field?");
        Scanner scanner = new Scanner(System.in);

        MineCountField field = new MineCountField(scanner.nextInt());
        scanner.nextLine();
        field.print();

        Game game = new Game(field);
        game.run(scanner);
    }
}
