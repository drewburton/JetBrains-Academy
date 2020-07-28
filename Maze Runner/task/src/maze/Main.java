package maze;

public class Main {
    public static void main(String[] args) {
        Maze maze = MazeGenerator.generate();
        maze.print();
    }
}
