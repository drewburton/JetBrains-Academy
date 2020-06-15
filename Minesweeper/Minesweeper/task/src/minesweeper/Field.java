package minesweeper;

import java.util.ArrayList;
import java.util.Random;

public class Field {
    private ArrayList<ArrayList<Boolean>> field;

    public Field() {
        this(9, 9);
    }

    public Field(int length, int width) {
        field = new ArrayList<>();
        Random random = new Random();
        for (int row = 0; row < length; row++) {
            ArrayList<Boolean> line = new ArrayList<>();
            for (int column = 0; column < width; column++) {
                line.add(random.nextBoolean());
            }
            field.add(line);
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
}
