package solver;

import java.util.ArrayList;

public class Row {
    private ArrayList<Complex> row;
    
    public Row() {
        row = new ArrayList<>();
    }

    public boolean add(Complex d) {
        return row.add(d);
    }

    public Complex get(int index) {
        return row.get(index);
    }

    public int size() {
        return row.size();
    }

    public Row add(Row row) {
        Row added = new Row();

        for (int i = 0; i < row.size(); i++) {
            added.add(row.get(i).add(this.row.get(i)));
        }
        return added;
    }

    public Complex set(int index, Complex element) {
        return row.set(index, element);
    }

    public Row subtract(Row row) {
        Row subtracted = new Row();

        for (int i = 0; i < row.size(); i++) {
            subtracted.add(this.row.get(i).subtract(row.get(i)));
        }
        return subtracted;
    }

    public Row multiply(Complex factor) {
        Row multiplied = new Row();
        for (int i = 0; i < row.size(); i++) {
             multiplied.add(row.get(i).multiply(factor));
        }
        return multiplied;
    }

    public Row divide(Complex factor) {
        Row divided = new Row();
        for (int i = 0; i < row.size(); i++) {
            divided.add(row.get(i).divide(factor));
        }
        return divided;
    }

    public ArrayList<Complex> toList() {
        return row;
    }
}
