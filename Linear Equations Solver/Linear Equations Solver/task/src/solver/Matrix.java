package solver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Matrix {
    private ArrayList<Row> coefficients;

    public Matrix(String[] args) {
        getCoefficients(args);
    }

    private void getCoefficients(String[] args) {
        System.out.println("Retrieving coefficients");

        coefficients = new ArrayList<>();

        Scanner scanner;
        try {
            scanner = new Scanner(new File(args[1]));
        } catch (FileNotFoundException e) {
            try {
                scanner = new Scanner(new File(
                        "C:\\development\\Learning\\Java\\IdeaProjects\\Linear Equations Solver" +
                        "\\Linear Equations Solver\\task\\src\\solver\\test.txt"));
            } catch (FileNotFoundException f) {
                System.out.println("no file");
                return;
            }
        }

        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] numbers = line.split("\\s");

            Row equation = new Row();
            for (String number : numbers) {
                double num = Double.parseDouble(number);
                equation.add(num);
            }
            coefficients.add(equation);
        }
        scanner.close();
        print();
    }

    public int size() {
        return coefficients.size();
    }

    public void print() {
        coefficients.forEach(row -> {
            for (int i = 0; i < row.size(); i++) {
                System.out.print(row.get(i) + " ");
            }
            System.out.println();
        });

        System.out.println();
    }

    protected void swapRows(int row1, int row2) {
        Row temp = coefficients.get(row1);
        coefficients.set(row1, coefficients.get(row2));
        coefficients.set(row2, temp);
    }

    protected void swapColumns(int column1, int column2) {
        for (int row = 0; row < coefficients.size(); row++) {
            double temp = coefficients.get(row).get(column1);
            coefficients.get(row).set(column1, coefficients.get(row).get(column2));
            coefficients.get(row).set(column2, temp);
        }
    }

    protected Row getRow(int rowIndex) {
        return coefficients.get(rowIndex);
    }

    protected ArrayList<Double> getColumn(int columnIndex) {
        ArrayList<Double> list = new ArrayList<>();
        for (int row = 0; row < size(); row++) {
            list.add(getElement(row, columnIndex));
        }
        return list;
    }

    protected double getElement(int row, int column) { return coefficients.get(row).get(column); }

    protected void setRow(int rowIndex, Row row) {
        coefficients.set(rowIndex, row);
    }

    protected int getSigEqs() {
        int count = 0;
        for (int row = 0; row < size(); row++) {
            for (int column = 0; column < coefficients.get(row).size(); column++) {
                if (getElement(row, column) != 0) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    protected int getSigVars() {
        return getRow(0).size() - 1;
    }

    protected void removeZeroRows() {
        ArrayList<Integer> toBeRemoved = new ArrayList<>();
        for (int row = 0; row < size(); row++) {
            for (int column = 0; column < getRow(row).size(); column++) {
                if (column == getRow(row).size() - 1 && getElement(row, column) == 0) {
                    toBeRemoved.add(row);
                } else if (getElement(row, column) != 0) {
                    break;
                }
            }
        }

        for (int index : toBeRemoved) {
            coefficients.remove(index);
        }
    }
}
