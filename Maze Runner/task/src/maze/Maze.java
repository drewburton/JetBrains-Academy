package maze;

public class Maze {
    boolean[][] maze;

    protected Maze() {}

    protected Maze(boolean[][] maze) {
        this.maze = maze;
    }

    public void print() {
        for (int row = 0; row < 10; row++) {
            for(int column = 0; column < 10; column++) {
                if (maze[row][column]) {
                    System.out.print("  ");
                } else {
                    System.out.print("\u2588\u2588");
                }
            }
            System.out.println();
        }
    }
}
