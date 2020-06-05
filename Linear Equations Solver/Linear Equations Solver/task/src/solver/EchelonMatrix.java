package solver;

public class EchelonMatrix {
    Matrix matrix;

    public EchelonMatrix(Matrix m) throws SolutionException{
        matrix = m;
        reduce();
    }

    private void reduce() throws SolutionException{

    }
}
