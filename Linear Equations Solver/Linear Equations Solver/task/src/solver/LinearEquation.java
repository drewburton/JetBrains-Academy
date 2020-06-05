package solver;

import java.io.File;
import java.util.ArrayList;

public class LinearEquation {
    private Matrix matrix;

    public LinearEquation(String[] args) {
        matrix = new Matrix();
        matrix.getCoefficients(args);
    }

    public ArrayList<String> solve() {
        try {
            EchelonMatrix echelon = new EchelonMatrix(matrix);
            ReducedEchelonMatrix reduced = new ReducedEchelonMatrix(echelon);

            ArrayList<String> variables = null;
            variables = reduced.getAnswer();
            System.out.println("Solution = " + variables.toString());
            return variables;
        } catch (SolutionException e) {
            ArrayList<String> result = new ArrayList<>();
            result.add(e.getMessage());
            return result;
        }
    }
}
