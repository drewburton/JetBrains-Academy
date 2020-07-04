package tictactoe;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    private ArrayList<ArrayList<Character>> board;
    private int Xs, Os, _s;

    public Board() {
        board = new ArrayList<>();
    }

    public void getInput() {
        System.out.println("Enter cells: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            switch(input.charAt(i)) {
                case 'X': Xs++;
                    break;
                case 'O': Os++;
                    break;
                case '_': _s++;
                    break;
                default:
                    System.out.println("bad char");
            }

            list.add(input.charAt(i));
        }

        for (int i = 0; i < 7; i += 3) {
            board.add(new ArrayList<>(list.subList(i, i + 3)));
        }
    }

    public void print() {
        System.out.println("---------");

        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int column = 0; column < 3; column++) {
                System.out.print(board.get(row).get(column) + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    char getCell(int row, int column) {
        return board.get(row).get(column);
    }

    int getXs() {
        return Xs;
    }

    int getOs() {
        return Os;
    }

    int get_s() {
        return _s;
    }

    int size() {
        return board.size();
    }
}
