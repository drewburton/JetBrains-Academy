package solver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Matrix {
    private ArrayList<Row> coefficients;

    public Matrix() {

    }

    public void getCoefficients() {
        System.out.println("Retrieving coefficients");

        coefficients = new ArrayList<>();

        Scanner scanner;
        try {
            scanner = new Scanner(new File("in.txt"));
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
        // reduce pivot row
        int pivot = 0;
        for (; pivot < coefficients.get(rowIndex).size(); pivot++) {
            if (coefficients.get(rowIndex).get(pivot) != 0) {
                break;
            }
        }

        double pivotDivisor = 0;
        try {
            pivotDivisor = coefficients.get(rowIndex).get(pivot);
        } catch (Exception e) {
            System.out.println("row is all 0");
            return;
        }

        Row row = new Row();
        for (int i = pivot; i < coefficients.get(rowIndex).size(); i++) {
            row.add(coefficients.get(rowIndex).get(i) / pivotDivisor);
        }
        coefficients.set(rowIndex, row);

        // reducing following rows
        for (int i = rowIndex; i < coefficients.size(); i++) {
            
        }
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
