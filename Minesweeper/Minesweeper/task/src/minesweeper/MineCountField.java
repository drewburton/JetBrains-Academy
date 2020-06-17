package minesweeper;

import java.awt.*;
import java.util.ArrayList;

public class MineCountField extends Field {
    ArrayList<ArrayList<Integer>> count;
    ArrayList<Point> marks;

    public MineCountField(int mines) {
        super(mines);
        count = new ArrayList<>();
        marks = new ArrayList<>();

        for (int row = 0; row < size; row++) {
            ArrayList<Integer> line = new ArrayList<>();
            for (int column = 0; column < size; column++) {
                    line.add(0);
            }
            count.add(line);
        }

        for (int row = 0; row < size; row++) {
            ArrayList<Integer> line = count.get(row);
            for (int column = 0; column < size; column++) {
                if (get(row, column)) {
                    countMine(row, column);
                }
            }
        }
    }

    private void countMine(int row, int column) {
        ArrayList<Integer> previous = row == 0 ? null : count.get(row - 1);
        ArrayList<Integer> current = count.get(row);
        ArrayList<Integer> next = row == (size - 1) ? null : count.get(row + 1);

        if (previous != null) {
            count.set(row - 1, increment(previous, column));
        }

        count.set(row, increment(current, column));

        if (next != null) {
            count.set(row + 1, increment(next, column));
        }
    }

    private ArrayList<Integer> increment(ArrayList<Integer> list, int column) {
        if (list != null) {
            if (column != 0) {
                list.set(column - 1, list.get(column - 1) + 1);
            }

            list.set(column, list.get(column) + 1);

            if (column != size - 1) {
                list.set(column + 1, list.get(column + 1) + 1);
            }
        }
        return list;
    }

    public void mark(int x, int y) {
        for (Point mark : marks) {
            if (mark.x == x && mark.y == y) {
                marks.remove(new Point(x, y));
                return;
            }
        }

        if (count.get(x).get(y) > 0) {
            System.out.println("There is a number here!");
            return;
        }

        marks.add(new Point(x, y));
    }

    @Override
    public void print() {
        System.out.println(" |123456789|");
        System.out.println("-|---------|");
        for (int row = 0; row < size; row++) {
            System.out.print((row + 1) + "|");
            for (int column = 0; column < size; column++) {
                boolean done = false;
                for (Point mark : marks) {
                    if (mark.x == row && mark.y == column) {
                        System.out.print("*");
                        done = true;
                    }
                }
                if (done) { continue; }

                if (get(row, column) || count.get(row).get(column) == 0) {
                    System.out.print(".");
                } else {
                    System.out.print(count.get(row).get(column));
                }
            }
            System.out.print("|\n");
        }
        System.out.println("-|---------|");
    }
}
