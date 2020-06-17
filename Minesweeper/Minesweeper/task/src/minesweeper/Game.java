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

            field.mark(x, y);

            field.print();
            if (isComplete()) {
                foundAll = true;
            }
        }
        System.out.println("Congratulations! You found all mines!");
    }

    private boolean isComplete() {
        ArrayList<Point> matched = new ArrayList<>();
        for (Point mine : hiddenMines) {
            for (Point mark : field.marks) {
                if ((mine.x == mark.x) && (mine.y == mark.y)) {
                    matched.add(mark);
                }
            }
        }

        if (matched.size() != field.marks.size()) {
            return false;
        }
        return true;
    }
}
