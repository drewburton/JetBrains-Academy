package solver;

import java.util.ArrayList;

public class EchelonMatrix extends Matrix {

    protected ArrayList<String> swaps;

    public EchelonMatrix(String[] args) throws SolutionException{
        super(args);
        swaps = new ArrayList<>();
        reduce();
    }

    private void reduce() throws SolutionException{
        System.out.println("reducing to echelon: ");

        for (int row = 0; row < size(); row++) {
            if (getElement(row, row) == 0) {
                try { findAndSwap(row); }
                catch(SolutionException e) { break; }
            }

            double pivot = getElement(row, row);
            setRow(row, getRow(row).divide(pivot));
            reduceFollowing(row);
        }

        print();
        System.out.println();

        checkNoSolutions();
    }

    private void reduceFollowing(int row) {
        if (row == size()  - 1) {
            return;
        }

        for (int i = row + 1; i < size(); i++) {
            double nextPivot = getElement(i, row);
            Row multiplied = getRow(row).multiply(nextPivot);
            Row subtracted = getRow(i).subtract(multiplied);
            super.setRow(i, subtracted);
        }
    }

    private void findAndSwap(int row) throws SolutionException {
        // scan vertically
        for (int i = row + 1; i < size(); i++) {
            if (getElement(i, row) != 0) {
                swapRows(row, i);
                return;
            }
        }

        // scan horizontally
        for (int i = row; i < getRow(row).size() - 1; i++) {
            if (getElement(row, i) != 0) {
                swapColumns(row, i);
                swaps.add(row + " " + i);
                return;
            }
        }

        // scan box
        for (int rowIndex = row + 1; rowIndex < size(); rowIndex++) {
            for (int column = row + 1; column < getRow(rowIndex).size() - 1; column++) {
                if (getElement(rowIndex, column) != 0) {
                    swapRows(row, rowIndex);
                    swapColumns(row, column);
                    swaps.add(row + " " + column);
                    return;
                }
            }
        }

        throw new NoSolutionException();
    }

    private void checkNoSolutions() throws SolutionException {
        System.out.println("checking no solution");

        for (int row = 0; row < size(); row++) {
            for (int column = 0; column < getRow(row).size(); column++) {
                if (column == getRow(row).size() - 1 && getElement(row, column) != 0) {
                    System.out.println("no solution");
                    throw new NoSolutionException();
                } else if (getElement(row, column) != 0) {
                    break;
                }
            }
        }

        int sigEqs = getSigEqs();
        int sigVars = getSigVars();
        if (sigEqs < sigVars) {
            System.out.println("infinite solutions");
            throw new InfSolutionsException();
        } else if (sigEqs != sigVars) {
            System.out.println("Wrong");
        }

        System.out.println("one solution");
        System.out.println();
    }
}
