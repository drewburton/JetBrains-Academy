package tictactoe;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.print();

        Analyzer analyzer = new Analyzer(board);
        boolean finished = false;
        while (!finished) {
            board.getTarget();
            board.print();
            finished = analyzer.analyse();
        }
    }
}
