package tictactoe;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.getInput();
        board.print();
        board.getTarget();
        board.print();
    }
}
