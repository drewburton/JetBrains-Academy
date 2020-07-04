package tictactoe;

import java.util.ArrayList;

public class Analyzer {
    private Board board;
    private Outcome winner = Outcome.N;

    public Analyzer(Board board) {
        this.board = board;
    }

    enum Outcome { X, O, N, D, I}

    public void analyse() {
        switch(getOutcome()) {
            case X: System.out.println("X wins");
                break;
            case O: System.out.println("O wins");
                break;
            case N: System.out.println("Game not finished");
                break;
            case D: System.out.println("Draw");
                break;
            case I: System.out.println("Impossible");
                break;
        }
    }

    private boolean Impossible() {
        int xs = board.getXs();
        int os = board.getOs();

        if (Math.abs(xs - os) > 1) {
            return true;
        }

        boolean x = row('X') || column('X') || diag('X');
        boolean o = row('O') || column('O') || diag('O');

        if (x && o) {
            return true;
        } else if (x) {
            winner = Outcome.X;
        } else if (o) {
            winner = Outcome.O;
        }

        return false;
    }

    private boolean row(char c) {
        for (int row = 0; row < board.size(); row++) {
            boolean firstTwoSame = board.getCell(row, 0) == board.getCell(row, 1);
            boolean secondTwoSame = board.getCell(row, 1) == board.getCell(row, 2);
            if (firstTwoSame && secondTwoSame && board.getCell(row, 0) == c) {
                return true;
            }
        }
        return false;
    }

    private boolean column(char c) {
        for (int column = 0; column < board.size(); column++) {
            boolean firstTwoSame = board.getCell(0, column) == board.getCell(1, column);
            boolean secondTwoSame = board.getCell(1, column) == board.getCell(2, column);
            if (firstTwoSame && secondTwoSame && board.getCell(0, column) == c) {
                return true;
            }
        }
        return false;
    }

    private boolean diag(char c) {
        boolean firstTwo = board.getCell(0, 0) == board.getCell(1, 1);
        boolean secondTwo = board.getCell(1, 1) == board.getCell(2, 2);
        if (firstTwo && secondTwo && board.getCell(0, 0) == c) {
            return true;
        }

        firstTwo = board.getCell(0, 2) == board.getCell(1, 1);
        secondTwo = board.getCell(1, 1) == board.getCell(2, 0);
        if (firstTwo && secondTwo && board.getCell(0, 0) == c) {
            return true;
        }
        return false;
    }

    private boolean finished() {
        if (board.get_s() > 0) {
            return false;
        }
        return true;
    }

    private Outcome getOutcome() {
        if (Impossible()) {
            return Outcome.I;
        } else if (winner == Outcome.X || winner == Outcome.O) {
            return winner;
        } else if (!finished()) {
            return Outcome.N;
        } else {
            return Outcome.D;
        }
    }
}
