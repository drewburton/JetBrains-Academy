package minesweeper;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Field {
    private ArrayList<ArrayList<Boolean>> field;
    int size = 9;

    public Field(int mines) {
        field = new ArrayList<>();
        for (int row = 0; row < size; row++) {
            ArrayList<Boolean> line = new ArrayList<>();
            for (int column = 0; column < size; column++) {
                line.add(false);
            }
            field.add(line);
        }

        Random random = new Random();
        for (int i = 0; i < mines; i++) {
            int row = (int) (random.nextDouble() * size);
            int column = (int) (random.nextDouble() * size);
            ArrayList<Boolean> line = field.get(row);

            if (line.get(column)) {
                i--;
                continue;
            }

            line.set(column, true);
            field.set(row, line);
        }
    }

    public void print() {
        for (int row = 0; row < field.size(); row++) {
            for (int column = 0; column < field.get(row).size(); column++) {
                System.out.print(field.get(row).get(column) ? "X" : ".");
            }
            System.out.println();
        }
    }

    public boolean get(int row, int column) {
        return field.get(row).get(column);
    }

    public ArrayList<Point> getMines() {
        ArrayList<Point> list = new ArrayList<>();
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                if (get(row, column)) {
                    list.add(new Point(row, column));
                }
            }
        }
        return list;
    }
}
