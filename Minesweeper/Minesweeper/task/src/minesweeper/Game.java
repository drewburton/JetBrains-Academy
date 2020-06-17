package minesweeper;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private MineCountField field;
    private ArrayList<Point> hiddenMines;

    public Game(MineCountField field) {
        this.field = field;
        hiddenMines = field.getMines();
    }

    public void run(Scanner scanner) {
        boolean foundAll = hiddenMines.size() == 0;

        while (!foundAll) {
            System.out.println("Set/delete mines marks (x and y coordinates):");
            String line = scanner.nextLine();
            String[] parts = line.split("\\s");
            int y = Integer.parseInt(parts[0]) - 1;
            int x = Integer.parseInt(parts[1]) - 1;

            if ("mine".equals(parts[2])) {
                field.mark(x, y, MineCountField.Flag.MINE);
            } else if ("free".equals(parts[2])) {
                if (field.mark(x, y, MineCountField.Flag.FREE)) {
                    return;
                }
            }

            field.print();
            if (isComplete()) {
                return;
            }
        }
    }

    private boolean isComplete() {
        return true;
    }
}
