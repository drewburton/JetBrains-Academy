package tictactoe;

import java.util.ArrayList;

public class Analyzer {
    private Board board;

    public Analyzer(Board board) {
        this.board = board;
    }

    public void analyse() {
        // check for game not finished
        // check for who won or tie

        int Xs = board.getXs();
        int Os = board.getOs();
        int _s = board.get_s();

        if (Math.abs(Xs - Os) >= 2) {
            System.out.println("Impossible");
            return;
        }

        boolean X = false;
        boolean O = false;
        for (int row = 0; row < 3; row++) {
            ArrayList<Character> list = board.getRow(row);
            if (list.get(0) == list.get(1) && list.get(1) == list.get(2)) {
                if (list.get(0) == 'X') {
                    X = true;
                } else if (list.get(0) == 'O') {
                    O = true;
                }
            }

            if (X && O) {
                System.out.println("Impossible");
                return;
            }
        }

        if (_s > 0) {
            System.out.println("Game not finished");
            return;
        }

        
    }
}
