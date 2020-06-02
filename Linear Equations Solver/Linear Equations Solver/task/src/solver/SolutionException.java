package solver;

abstract class SolutionException extends Exception {
    public SolutionException() {
        super();
    }
}

class NoSolutionException extends SolutionException {
    public NoSolutionException() {
        super();
    }

    @Override
    public String getMessage() {
        return "No solutions";
    }
}

class InfSolutionsException extends  SolutionException {
    public InfSolutionsException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Infinitely many solutions";
    }
}
