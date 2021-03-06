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

    public boolean mark(int x, int y, Flag flag, boolean firstTime) {
        if (flag == Flag.FREE && get(x, y) && firstTime) {
            resetMine(x, y);
        }

        if (flag == Flag.MINE) {
            for (int i = 0; i < marks.size(); i++) {
                String mark = marks.get(i);
                String[] parts = mark.split("\\s");
                int markX = Integer.parseInt(parts[0]);
                int markY = Integer.parseInt(parts[1]);
                if (markX == x && markY == y && "MINE".equals(parts[2])) {
                    marks.remove(i);
                    return false;
                }
            }

            if (get(x, y)) {
                marks.add(x + " " + y + " " + flag);
            } else if (count.get(x).get(y) > 0) {
                for (String mark : marks) {
                    String[] parts = mark.split("\\s");
                    int markX = Integer.parseInt(parts[0]);
                    int markY = Integer.parseInt(parts[1]);
                    if (markX == x && markY == y) {
                        System.out.println("There is a number here!");
                        return false;
                    }
                }
                marks.add(x + " " + y + " " + flag);
            } else {
                marks.add(x + " " + y + " " + flag);
            }

            return false;
        } else if (get(x, y)) {
            printAll();
            System.out.println("You stepped on a mine and failed");
            marks.add(x + " " + y + " " + flag);
            return true;
        } else if (count.get(x).get(y) == 0) {
            for (int row = x - 1; row < x + 2; row++) {
                for (int column = y - 1; column < y + 2; column++) {
                    if (row >= size || row < 0 || column >= size || column < 0) {
                        continue;
                    }

                    boolean done = false;
                    ArrayList<String> removeList = new ArrayList<>();
                    for (String mark : marks) {
                        String[] parts = mark.split("\\s");
                        int markX = Integer.parseInt(parts[0]);
                        int markY = Integer.parseInt(parts[1]);
                        if (markX == row && markY == column) {
                            done = true;
                        }
                        if (markX == row && markY == column && "MINE".equals(parts[2])) {
                            removeList.add(markX + " " + markY + " MINE");
                            done = false;
                        }
                    }

                    for (String remove : removeList) {
                        marks.remove(remove);
                    }

                    if (!done) {
                        marks.add(x + " " + y + " " + flag);
                        mark(row, column, Flag.FREE, false);
                    }
                }
            }
        } else {
            boolean done = false;
            for (String mark : marks) {
                String[] parts = mark.split("\\s");
                int markX = Integer.parseInt(parts[0]);
                int markY = Integer.parseInt(parts[1]);
                if (markX == x && markY == y) {
                    done = true;
                }
            }
            if (!done) {
                marks.add(x + " " + y + " " + flag);
            }
        }
        return false;
    }

    @Override
    public void print() {
        System.out.println(" |123456789|");
        System.out.println("-|---------|");
        for (int row = 0; row < size; row++) {
            System.out.print((row + 1) + "|");
            for (int column = 0; column < size; column++) {
                boolean done = false;
                for (String mark : marks) {
                    String[] parts = mark.split("\\s");
                    int x = Integer.parseInt(parts[0]);
                    int y = Integer.parseInt(parts[1]);
                    if (row == x && column == y && "MINE".equals(parts[2])) {
                        System.out.print("*");
                        done = true;
                        break;
                    }
                }
                if (!done) {
                    for (String mark : marks) {
                        String[] parts = mark.split("\\s");
                        int x = Integer.parseInt(parts[0]);
                        int y = Integer.parseInt(parts[1]);
                        if (row == x && column == y && "FREE".equals(parts[2]) && count.get(x).get(y) > 0) {
                            System.out.print(count.get(x).get(y));
                            done = true;
                            break;
                        } else if (row == x && column == y && "FREE".equals(parts[2])) {
                            System.out.print("/");
                            done = true;
                            break;
                        }
                    }
                }

                if (!done) {
                    System.out.print(".");
                }
            }
            System.out.print("|\n");
        }
        System.out.println("-|---------|");
    }

    public void printAll() {
        System.out.println(" |123456789|");
        System.out.println("-|---------|");
        for (int row = 0; row < size; row++) {
            System.out.print((row + 1) + "|");
            for (int column = 0; column < size; column++) {
                boolean done = false;
                for (String mark : marks) {
                    String[] parts = mark.split("\\s");
                    int x = Integer.parseInt(parts[0]);
                    int y = Integer.parseInt(parts[1]);
                    if (row == x && column == y && "MINE".equals(parts[2])) {
                        System.out.print("*");
                        done = true;
                        break;
                    }
                }

                if (get(row, column)) {
                    System.out.print("X");
                    continue;
                }

                if (!done) {
                    for (String mark : marks) {
                        String[] parts = mark.split("\\s");
                        int x = Integer.parseInt(parts[0]);
                        int y = Integer.parseInt(parts[1]);
                        if (row == x && column == y && "FREE".equals(parts[2]) && count.get(x).get(y) > 0) {
                            System.out.print(count.get(x).get(y));
                            done = true;
                            break;
                        } else if (row == x && column == y && "FREE".equals(parts[2])) {
                            System.out.print("/");
                            done = true;
                            break;
                        }
                    }
                }

                if (!done) {
                    System.out.print(".");
                }
            }
            System.out.print("|\n");
        }
        System.out.println("-|---------|");
    }
}
