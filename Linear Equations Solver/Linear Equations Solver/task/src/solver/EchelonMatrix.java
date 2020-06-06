package solver;

public class EchelonMatrix extends Matrix implements ReducedMatrix {

    public EchelonMatrix(String[] args) throws SolutionException{
        super(args);
        reduce();
    }

    public void reduce() throws SolutionException{
        for (int row = 0; row < super.size(); row++) {
            if (super.getElement(row, row) == 0) {
                try { findAndSwap(row); }
                catch(SolutionException e) { break; }
            }

            double pivot = super.getElement(row, row);
            super.getRow(0).multiply(1 / pivot);
            reduceFollowing(row);
        }

        checkNoSolutions();
    }

    private void reduceFollowing(int row) {
        if (row == super.size()  - 1) {
            return;
        }

        for (int i = row + 1; i < super.size(); i++) {
            double nextPivot = super.getElement(i, row);
            Row multiplied = super.getRow(row).multiply(nextPivot);
            Row subtracted = super.getRow(i).subtract(multiplied);
            super.setRow(row, subtracted);
        }
    }

    private void findAndSwap(int row) throws SolutionException {
        throw new NoSolutionException();
    }

    private void checkNoSolutions() throws SolutionException {

    }
}
