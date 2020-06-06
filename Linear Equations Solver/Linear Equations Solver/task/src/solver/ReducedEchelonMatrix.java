package solver;

import java.util.ArrayList;

public class ReducedEchelonMatrix extends EchelonMatrix implements ReducedMatrix {

    public ReducedEchelonMatrix(String[] args) throws SolutionException {
        super(args);
        reduce();
    }


    public void reduce() throws SolutionException {

    }

    public ArrayList<String> getAnswer() {
        return null;
    }
}
