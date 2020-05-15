package life;

import java.io.IOException;
import java.util.Random;

public class Universe {
    private final int size;
    private final int seed;

    Generation currentGeneration;

    public Universe(int size, int seed) {
        this.size = size;
        this.seed = seed;
    }

    public void generateNew() {
        Random random = new Random();

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

    public void runUniverse(int generations) {
        generations = 10;
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
            currentGeneration.print();

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
