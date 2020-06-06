package solver;

import java.io.File;
import java.util.ArrayList;

public class LinearEquation {
    private ReducedEchelonMatrix matrix;
    private String message;

    public LinearEquation(String[] args) {
        try {
            matrix = new ReducedEchelonMatrix(args);
        } catch (SolutionException e) {
            message = e.getMessage();
        }
    }

    public ArrayList<String> solve() {
        if (message == null) {
            ArrayList<String> variables = null;
            variables = matrix.getAnswer();
            System.out.println("Solution = " + variables.toString());
            return variables;
        }

        ArrayList<String> result = new ArrayList<>();
        result.add(message);
        return result;
    }
}
