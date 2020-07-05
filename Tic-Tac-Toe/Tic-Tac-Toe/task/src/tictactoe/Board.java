package tictactoe;

import java.util.ArrayList;
import java.util.NoSuchElementException;
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
        scanner.close();

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

    public void getTarget() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the coordinates: ");
            int x, y;
            try {
                x = scanner.nextInt();
                y = scanner.nextInt();
            } catch(NoSuchElementException e) {
                System.out.println("You should enter number!");
                continue;
            }
            scanner.nextLine();

            int row = Math.abs(y - 3);
            int column = x - 1;

            if (x > 3 || x < 1 || y > 3 || y < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            } else if (board.get(row).get(column) != '_') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            ArrayList<Character> newRow = board.get(row);
//            if (getXs() - getOs() > 0) {
//                newRow.set(column, 'O');
//            } else {
//                newRow.set(column, 'X');
//            }
            newRow.set(column, 'X');
            board.set(row, newRow);
            break;
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
