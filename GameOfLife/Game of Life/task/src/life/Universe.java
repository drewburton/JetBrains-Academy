package life;

import java.io.IOException;
import java.util.Random;

public class Universe {
    private int size;

    Generation currentGeneration;

    public Universe(int size) {
        this.size = size;
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

    public void runUniverse() {
        int generations = 10;
        Thread universeThread = new Thread();

        for (int i = 0; i < generations; i++) {
            int generation = 1;

            // clears console output
            try {
                if (System.getProperty("os.name").contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    Runtime.getRuntime().exec("clear");
                }
            } catch (IOException | InterruptedException e) {
            }

            System.out.println("Generation: " + generation);
            System.out.println("Alive: " + currentGeneration.getAlive());

            // prints generation
            currentGeneration.print();

            advanceGeneration();
            try {
                universeThread.wait(1000L);
            } catch(InterruptedException e) {
               System.out.println("Universe Interrupted");
               return;
            }
        }
    }
}
