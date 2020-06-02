package solver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Matrix {
    private ArrayList<Row> coefficients;
    private ArrayList<String> swaps;

    public Matrix() {
        swaps = new ArrayList<>();
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

    public void pivot(int rowIndex) throws SolutionException{
        int pivot = reduceRow(rowIndex);

        // reducing following rows
        for (int i = rowIndex + 1; i < coefficients.size(); i++) {
            double multiplier = coefficients.get(i).get(pivot);
            Row multipliedFirst = coefficients.get(rowIndex).multiply(multiplier);
            Row cleared = coefficients.get(i).subtract(multipliedFirst);
            coefficients.set(i, cleared);
        }
    }

    private int reduceRow(int rowIndex) throws SolutionException{
        int pivot = getPivot(rowIndex - 1) + 1;

        if (coefficients.get(rowIndex).get(pivot) == 0) {
            rearrange(rowIndex, pivot);
        }

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

    private void rearrange(int rowIndex, int pivot) throws SolutionException {
        for (int i = rowIndex + 1; i < coefficients.size(); i++) {
            if (coefficients.get(i).get(pivot) != 0) {
                swapVertical(rowIndex, i);
                return;
            }
        }

        for (int i = pivot + 1; i < coefficients.get(rowIndex).size() - 1; i++) {
            if (coefficients.get(rowIndex).get(i) != 0) {
                swapHorizontal(rowIndex, pivot, i);
            }
        }

        for (int row = rowIndex + 1; row < coefficients.size(); row++) {
            for (int column = pivot + 1; column < coefficients.get(row).size(); column++) {
                if (coefficients.get(row).get(column) != 0) {
                    swapVertical(rowIndex, row);
                    swapHorizontal(rowIndex, pivot, column);
                }
            }
        }

        checkNoSolutions();

        // 2 swap vertical
        // 3 swap horizontal (remember because variables switched)
        // 4 look for any in bottom corner, swap row & column
        // 5 end part, check no solutions
            // a. significant equations = sig vars 1 sol
            // b. sig eq < sig vars infinite sol
    }

    private void swapVertical(int row1, int row2) {

    }

    private void swapHorizontal(int row, int column1, int column2) {

    }

    private void checkNoSolutions() throws SolutionException {

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

    public ArrayList<String> getVariablesColumn() {
        ArrayList<String> column = new ArrayList<>();
        for (Row row : coefficients) {
            column.add(row.get(row.size() - 1) + "");
        }
        return column;
    }
}
