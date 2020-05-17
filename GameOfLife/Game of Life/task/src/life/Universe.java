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
            game.createMap(currentGeneration, generationCount);
            advanceGeneration();
            try {
                sleep(300L);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void runUniverse() {
        int generations = 10;
        Thread universeThread = new Thread();

        for (int i = 1; i <= generations; i++) {
            // clears console output
            try {
                if (System.getProperty("os.name").contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    Runtime.getRuntime().exec("clear");
                }
            } catch (IOException | InterruptedException e) {
            }

            System.out.println("Generation: #" + i);
            System.out.println("Alive: " + currentGeneration.getAlive());

            //prints generation
            //currentGeneration.print();

            advanceGeneration();
            try {
                universeThread.sleep(1000L);
            } catch(InterruptedException e) {
               System.out.println("Universe Interrupted");
               return;
            }
        }
    }
}
