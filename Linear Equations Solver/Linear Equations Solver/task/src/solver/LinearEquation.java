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
        echelonForm();
        reducedEchelonForm();

        ArrayList<String> variables = null;
        System.out.println("Valid Matrix");
        variables = matrix.getVariablesColumn();
        System.out.println("Solution = " + variables.toString());
        return variables;
    }

    private void echelonForm() {
        System.out.println("Reducing to echelon");
        for (int i = 0; i < matrix.size(); i++) {
            matrix.pivot(i);
        }
        matrix.print();
    }

    private void reducedEchelonForm() {
        System.out.println("Reducing to reduced echelon");
        for (int i = matrix.size() - 1; i > 0; i--) {
            matrix.nullAboveElements(i);
        }
        matrix.print();
    }
}
