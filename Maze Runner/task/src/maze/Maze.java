package maze;

public class Maze {
    int[][] maze = {
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 0, 0, 1, 0, 1, 0, 1, 0, 0, 1 },
            { 1, 0, 1, 0, 0, 0, 1, 0, 1, 1 },
            { 1, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
            { 1, 0, 1, 0, 0, 0, 0, 0, 1, 1 },
            { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
            { 1, 0, 1, 0, 1, 0, 0, 0, 1, 1 },
            { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
            { 1, 0, 1, 0, 0, 0, 1, 0, 0, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
    };

    public Maze() {

    }

    public void print() {
        for (int row = 0; row < 10; row++) {
            for(int column = 0; column < 10; column++) {
                if (maze[row][column] == 1) {
                    System.out.print("\u2588\u2588");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
