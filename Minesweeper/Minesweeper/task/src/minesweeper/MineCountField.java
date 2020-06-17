package minesweeper;

import java.awt.*;
import java.util.ArrayList;

public class MineCountField extends Field {
    ArrayList<ArrayList<Integer>> count;
    ArrayList<String> marks;

    public enum Flag { MINE, FREE };

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

    public boolean mark(int x, int y, Flag flag) {
        if (flag == Flag.MINE) {
            for (int i = 0; i < marks.size(); i++) {
                String mark = marks.get(i);
                String[] parts = mark.split("\\s");
                int markX = Integer.parseInt(parts[0]);
                int markY = Integer.parseInt(parts[1]);
                if (markX == x && markY == y) {
                    marks.remove(i);
                    return false;
                }
            }

            if (count.get(x).get(y) > 0) {
                System.out.println("There is a number here!");
                return false;
            }

            marks.add(x + " " + y + " " + flag);
            return false;
        } else if (get(x, y)) {
            System.out.println("You stepped on a mine and failed");
            marks.add(x + " " + y + " " + flag);
            print();
            return true;
        } else if (count.get(x).get(y) == 0) {
            for (int row = x - 1; row < x + 2; row++) {
                for (int column = y - 1; column < y + 2; column++) {
                    if (row >= size || row < 0 || column >= size || column < 0 || (row == x && column == y)) {
                        break;
                    }

                    mark(row, column, Flag.FREE);
                }
            }
        }

        marks.add(x + " " + y + " " + flag);

        return false;
    }

    @Override
    public void print() {
        System.out.println(" |123456789|");
        System.out.println("-|---------|");
        for (int row = 0; row < size; row++) {
            System.out.print((row + 1) + "|");
            for (int column = 0; column < size; column++) {
                System.out.print(".");
            }
            System.out.print("|\n");
        }
        System.out.println("-|---------|");
    }
}
