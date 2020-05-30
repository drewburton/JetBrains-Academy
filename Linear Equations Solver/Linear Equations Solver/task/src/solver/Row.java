package solver;

import java.util.ArrayList;

public class Row extends Matrix {
    private ArrayList<Double> row;

    public Row() {
        row = new ArrayList<>();
    }

    public boolean add(double d) {
        return row.add(d);
    }

    public Double get(int index) {
        return row.get(index);
    }

    public int size() {
        return row.size();
    }

    public Row add(Row row) {
        Row added = new Row();

        for (int i = 0; i < row.size(); i++) {
            added.add(row.get(i) + this.row.get(i));
        }
        return added;
    }

    public Row subtract(Row row) {
        Row subtracted = new Row();

        for (int i = 0; i < row.size(); i++) {
            subtracted.add(this.row.get(i) - row.get(i));
        }
        return subtracted;
    }

    public Row multiply(double factor) {
        Row multiplied = new Row();
        for (int i = 0; i < row.size(); i++) {
             multiplied.add(row.get(i) * factor);
        }
        return multiplied;
    }
}
