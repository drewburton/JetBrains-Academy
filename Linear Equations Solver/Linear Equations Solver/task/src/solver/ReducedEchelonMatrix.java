package solver;

import java.util.ArrayList;

public class ReducedEchelonMatrix extends EchelonMatrix {

    public ReducedEchelonMatrix(String[] args) throws SolutionException {
        super(args);
        this.reduce();
    }


    private void reduce() throws SolutionException {
        System.out.println("reducing to reduced row");

        for (int row = size() - 1; row > 0; row--) {
            int pivot = getPivot(row);
            if (pivot != -1) {
                reduceAbove(row, pivot);
            }
        }

        print();
        System.out.println();
    }

    private int getPivot(int row) {
        for (int column = 0; column < getRow(row).size(); column++) {
            if (getElement(row, column) == 1.0) {
                return column;
            }
        }
        return -1;
    }

    private void reduceAbove(int row, int pivot) {
        if (row == 0) {
            return;
        }

        for (int i = row - 1; i >= 0; i--) {
            Row multiplied = getRow(row).multiply(getElement(i, pivot));
            Row subtracted = getRow(i).subtract(multiplied);
            setRow(i, subtracted);
        }
    }

    public ArrayList<String> getAnswer() {
        swapBack();
        removeZeroRows();

        ArrayList<Double> answers = getColumn(getRow(0).size() - 1);
        ArrayList<String> stringAnswers = new ArrayList<>();
        for (double answer : answers) {
            stringAnswers.add(answer + "");
        }
        return stringAnswers;
    }

    private void swapBack() {
        for (int i = 0; i < swaps.size(); i++) {
            String[] swapped = swaps.get(i).split("\\s");
            int column1 = Integer.parseInt(swapped[0]);
            int column2 = Integer.parseInt(swapped[1]);
            swapRows(column1, column2);
        }
    }
}
