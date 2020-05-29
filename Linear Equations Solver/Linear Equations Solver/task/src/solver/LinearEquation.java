package solver;

import java.io.File;
import java.util.ArrayList;

public class LinearEquation {
    private Matrix matrix;

    public LinearEquation() {
        matrix = new Matrix();
        matrix.getCoefficients();
    }

    public ArrayList<Double> solve() {
        echelonForm();
        reducedEchelonForm();

        ArrayList<Double> variables = null;
        if (isGoodMatrix()) {
            System.out.println("Valid Matrix");
            variables = matrix.getVariablesColumn();
            System.out.println("Solution = " + variables.toString());
        }
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
    }

    private boolean isGoodMatrix() {
        System.out.println("Checking for valid matrix");
        return false;
    }
}
