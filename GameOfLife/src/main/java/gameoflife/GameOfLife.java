package gameoflife;

import java.util.Arrays;

public class GameOfLife {
    private final boolean[][] cells;

    public GameOfLife(int gridSize) {
        this.cells = new boolean[gridSize][gridSize];
    }

    public void alive(int x, int y) {
        cells[x][y] = true;
    }

    public boolean[][] nextGeneration() {
        boolean[][] newCells = cloneCells();

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                int nbOfLiveNeighbours = getNumberOfAliveNeighbours(i, j);

                if (nbOfLiveNeighbours < 2 && cells[i][j]) //underpopulation
                    newCells[i][j] = false;
                else if (nbOfLiveNeighbours > 3 && cells[i][j]) //overcrowding
                    newCells[i][j] = false;
            }
        }
        return newCells;
    }

    private boolean[][] cloneCells() {
        boolean newCells[][] = new boolean[cells.length][cells.length];
        for (int i = 0; i < cells.length; i++) {
            newCells[i] = Arrays.copyOf(cells[i], cells[i].length);
        }
        return newCells;
    }

    private int getNumberOfAliveNeighbours(int x, int y) {
        int nbOfAliveNeighbours = 0;

        for (int i = -1; i <= 1; i++)
            for (int j = -1; j <= 1; j++)
                if (i == 0 && j == 0)
                    continue;
                else if (isCellAlive(x + i, y + j))
                    nbOfAliveNeighbours++;

        return nbOfAliveNeighbours;
    }

    private boolean isCellAlive(int x, int y) {
        return isValidPosition(x) && isValidPosition(y) && cells[x][y];
    }

    private boolean isValidPosition(int pos) {
        return pos >= 0 && pos <= cells.length - 1;
    }
}