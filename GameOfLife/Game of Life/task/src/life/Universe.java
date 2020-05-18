package life;

import java.io.IOException;
import java.util.Random;

public class Universe extends Thread{
    private final int size;
    private final int seed;
    private GameOfLife game;

    private Generation currentGeneration;
    private int generationCount;

    public Universe(int size, int seed, GameOfLife game) {
        this.size = size;
        this.seed = seed;
        this.game = game;
    }

    public Universe(GameOfLife game) {
        size = 100;
        seed = -1;
        this.game = game;
    }

    public Universe(int size, GameOfLife game) {
        this.size = size;
        seed = -1;
        this.game = game;
    }

    public void generateNew() {
        Random random;
        if (seed != -1) {
            random = new Random(seed);
        } else {
            random = new Random();
        }

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
        generationCount++;
    }

    @Override
    public void run() {
        generationCount = 1;
        generateNew();
        while (!isInterrupted()) {
            if (!game.isPaused()) {
                game.createMap(currentGeneration, generationCount);
                advanceGeneration();

                try {
                    sleep(100L);
                } catch (InterruptedException e) {
                    break;
                }
            }
            handleReset();
        }
    }

    private void handleReset() {
        if (game.isReset()) {
            game.setReset(false);
            generationCount = 1;
            generateNew();
            game.createMap(currentGeneration, generationCount);
        }
    }
}