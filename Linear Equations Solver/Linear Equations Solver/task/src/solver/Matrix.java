package solver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Matrix {
    private ArrayList<Row> coefficients;

    public Matrix() {

    }

    public void getCoefficients(String[] args) {
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

    public void pivot(int rowIndex) {
        int pivot = reduceRow(rowIndex);

        // reducing following rows
        for (int i = rowIndex + 1; i < coefficients.size(); i++) {
            double multiplier = coefficients.get(i).get(pivot);
            Row multipliedFirst = coefficients.get(rowIndex).multiply(multiplier);
            Row cleared = coefficients.get(i).subtract(multipliedFirst);
            coefficients.set(i, cleared);
        }
    }

    private int reduceRow(int rowIndex) {
        int pivot = getPivot(rowIndex);

        double pivotDivisor = 0;
        try {
            pivotDivisor = coefficients.get(rowIndex).get(pivot);
        } catch (Exception e) {
            System.out.println("row is all 0");
            return -1;
        }

        Row row = new Row();
        for (int i = 0; i < coefficients.get(rowIndex).size(); i++) {
            row.add(coefficients.get(rowIndex).get(i) / pivotDivisor);
        }
        coefficients.set(rowIndex, row);
        return pivot;
    }

    public void nullAboveElements(int rowIndex) {
        if (rowIndex == 0) {
            return;
        }

        int pivot = getPivot(rowIndex);

        for (int i = rowIndex - 1; i >= 0; i--) {
            double multiplier = coefficients.get(i).get(pivot);
            Row multipliedRow = coefficients.get(rowIndex).multiply(multiplier);
            Row subtracted = coefficients.get(i).subtract(multipliedRow);
            coefficients.set(i, subtracted);
        }
    }

    private int getPivot(int rowIndex) {
        int pivot = 0;
        for (; pivot < coefficients.get(rowIndex).size(); pivot++) {
            if (coefficients.get(rowIndex).get(pivot) != 0.0) {
                break;
            }
        }
        return pivot;
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

    public ArrayList<Double> getVariablesColumn() {
        ArrayList<Double> column = new ArrayList<>();
        for (Row row : coefficients) {
            column.add(row.get(row.size() - 1));
        }
        return column;
    }
}
