package solver;

import java.util.ArrayList;

public abstract class Solver {
    protected ArrayList<Double> coefficients;

    protected Solver() {

    }

    protected abstract ArrayList<Double> getCoefficients();

    public abstract void solve();
}
