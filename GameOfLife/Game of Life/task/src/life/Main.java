package life;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GameOfLife game = new GameOfLife();

        Universe universe = new Universe(game);
        universe.start();

        try {
            universe.join();
        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted");
        }
    }
}