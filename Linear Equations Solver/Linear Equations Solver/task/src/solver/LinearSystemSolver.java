package solver;

import java.util.ArrayList;
import java.util.Scanner;

public class LinearSystemSolver extends Solver {

    public LinearSystemSolver() {
        super();
        coefficients = getCoefficients();
    }

    @Override
    protected ArrayList<Double> getCoefficients() {
        ArrayList<Double> coefficients = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextDouble()) {
            coefficients.add(scanner.nextDouble());
        }
        scanner.close();
        return coefficients;
    }

    @Override
    public void solve() {
        double x = getX();
        System.out.println(x + " " + getY(x));
    }

    private double getX() {
        double a = coefficients.get(0);
        double b = coefficients.get(1);
        double c = coefficients.get(2);
        double d = coefficients.get(3);
        double e = coefficients.get(4);
        double f = coefficients.get(5);

        double top = (f * b) - (e * c);
        double bottom = (d * b) - (a * e);

        return top / bottom;
    }

    private double getY(double x) {
        double a = coefficients.get(0);
        double b = coefficients.get(1);
        double c = coefficients.get(2);

        return (c / b) - (a / b) * x;
    }
}
