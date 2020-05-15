package life;

import java.util.Random;

public class Universe {
    private int size;
    private int seed;

    Generation currentGeneration;

    public Universe(int size, int seed) {
        this.size = size;
        this.seed = seed;
    }

    public void generateNew() {
        Random random = new Random(seed);

        boolean[][] map = new boolean[size][size];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                map[r][c] = random.nextBoolean();
            }
        }
        currentGeneration = new Generation(map);
    }

    public void advanceGeneration() {
        currentGeneration = currentGeneration.getNextGeneration();
    }

    public void printUniverse() {
        currentGeneration.print();
    }
}
