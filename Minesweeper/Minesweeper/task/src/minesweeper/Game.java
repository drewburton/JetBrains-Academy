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
        boolean firstTime = true;

        while (!foundAll) {
            System.out.println("Set/delete mines marks (x and y coordinates):");
            String line = scanner.nextLine();
            String[] parts = line.split("\\s");
            int y = Integer.parseInt(parts[0]) - 1;
            int x = Integer.parseInt(parts[1]) - 1;

            if ("mine".equals(parts[2])) {
                field.mark(x, y, MineCountField.Flag.MINE, firstTime);
            } else if ("free".equals(parts[2])) {
                if (field.mark(x, y, MineCountField.Flag.FREE, firstTime)) {
                    return;
                }
                firstTime = false;
            }

            field.print();
            if (isComplete()) {
                return;
            }
        }
    }

    private boolean isComplete() {
        int freeCount = 0;
        int mineCount = 0;
        for(int row = 0; row < field.size; row++) {
            for (int column = 0; column < field.size; column++) {
                boolean done = false;
                for (String mark : field.marks) {
                    String[] parts = mark.split("\\s");
                    int x = Integer.parseInt(parts[0]);
                    int y = Integer.parseInt(parts[1]);
                    if (row == x && column == y && "MINE".equals(parts[2])){
                        mineCount++;
                        done = true;
                        break;
                    }
                }

                if (mineCount == hiddenMines.size()) {
                    System.out.println("Congratulations! You found all mines!");
                    return true;
                }

                if (!done) {
                    for (String mark : field.marks) {
                        String[] parts = mark.split("\\s");
                        int x = Integer.parseInt(parts[0]);
                        int y = Integer.parseInt(parts[1]);
                        if (row == x && column == y && "FREE".equals(parts[2])){
                            freeCount++;
                            break;
                        }
                    }

                    if (freeCount == (field.size * field.size) - hiddenMines.size()) {
                        System.out.println("Congratulations! You found all mines!");
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
