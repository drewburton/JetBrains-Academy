package life;

import javafx.geometry.Point2D;

public class Generation {
    private boolean[][] map;

    public Generation(boolean[][] map) {
        this.map = map.clone();
    }

    public void print() {
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map.length; c++) {
                System.out.print(map[r][c] ? "O" : " ");
            }
            System.out.println();
        }
    }

    public int getAlive() {
        int alive = 0;
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map.length; c++) {
               if (map[r][c]) {
                   alive++;
               }
            }
        }
        return alive;
    }

    public Generation getNextGeneration() {
        boolean[][] next = new boolean[map.length][map.length];

        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map.length; c++) {
               Point2D cell = new Point2D(r, c);
               if (map[r][c] && willCellSurvive(cell)) {
                   next[r][c] = true;
               } else if (map[r][c]) {
                   next[r][c] = false;
               } else if (willCellRevive(cell)) {
                   next[r][c] = true;
               }
            }
        }

        return new Generation(next);
    }

    private boolean willCellRevive(Point2D cell) {
        if (getNeighbors(cell) == 3) {
            return true;
        }
        return false;
    }

    private boolean willCellSurvive(Point2D cell) {
        if (getNeighbors(cell) == 2 || getNeighbors(cell) == 3) {
            return true;
        }
        return false;
    }

    private int getNeighbors(Point2D cell) {
        int neighbors = 0;

        for (int l = -1; l <= 1; l++) {
            for (int u = -1; u <= 1; u++) {
                if (l == 0 && u == 0) {
                    continue;
                }
                int r = getWrapAround((int) cell.getX(), l);
                int c = getWrapAround((int) cell.getY(), u);
                neighbors += map[r][c] ? 1 : 0;
            }
        }
        return neighbors;
    }

    private int getWrapAround(int cell, int offset) {
        if (cell + offset >= map.length) {
            return cell + offset - map.length;
        } else if (cell + offset < 0) {
            return cell + offset + map.length;
        }
        return cell + offset;
    }
}
