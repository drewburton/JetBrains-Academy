package maze;

import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public abstract class MazeGenerator extends Maze {
    private MazeGenerator() {
        super();
    }

    public static Maze generate() {
        System.out.println("Please, enter the size of a maze");
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt() - 1;
        int width = scanner.nextInt() - 1;

        int[] maze = new int[height * width];
        Random random = new Random();

        for (int i = 0; i < maze.length; i++) {
            maze[i] = random.nextInt();
        }
        Arrays.sort(maze);

        UnionFind uf = new UnionFind(maze.length);
        for (int i = 0; i < maze.length; i++) {
           if (notConnected(maze, i, width, height, uf)) {
               switch(random.nextInt(4)) {
                   case 0: // check if valid and connect
                   case 1:
                   case 2:
                   case 3:
               }
           }
        }
    }

    private static boolean notConnected(int[] maze, int i, int width, int height, UnionFind uf) {
        int row = i / width;
        int column = i % width;

        boolean notConnectedUp = row > 0 && !uf.connected(maze[i], maze[i - width]);
        boolean notConnectedRight = column < width - 1 && !uf.connected(maze[i], maze[i + 1]);
        boolean notConnectedDown = row < height - 1 && !uf.connected(maze[i], maze[i + width]);
        boolean notConnectedLeft = column > 0 && !uf.connected(maze[i], maze[i - 1]);
        if (notConnectedUp && notConnectedRight && notConnectedDown && notConnectedLeft) {
            return true;
        }

        return false;
    }
}
