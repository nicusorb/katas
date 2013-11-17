package gameoflife;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GameOfLifeTest {
    private GameOfLife sut = new GameOfLife(4);

    @Test
    public void oneLiveCellWithNoAliveNeighbours_diesInNextGeneration() throws Exception {
        sut.alive(1, 1);

        boolean[][] cells = sut.nextGeneration();

        assertThat(cells[1][1], is(false));
    }

    @Test
    public void anyLiveCellWithLessThanTwoAliveNeighbours_diesInNextGeneration() throws Exception {
        sut.alive(0, 1);
        sut.alive(1, 1);

        boolean[][] cells = sut.nextGeneration();

        assertThatAllCellsAreDeath(cells);
    }

    @Test
    public void anyLiveCellWithMoreThanThreeNeighbours_diesInNextGeneration() throws Exception {
        sut.alive(0, 0);
        sut.alive(0, 1);
        sut.alive(1, 1);
        sut.alive(1, 0);
        sut.alive(1, 2);

        boolean[][] cells = sut.nextGeneration();

        assertThat(cells[1][1], is(false));
    }

    @Test
    public void anyLiveCellWithTwoNeighbours_livesInNextGeneration() throws Exception {
        sut.alive(0, 1);
        sut.alive(1, 1);
        sut.alive(1, 2);

        boolean[][] cells = sut.nextGeneration();

        assertThat(cells[1][1], is(true));
    }

    @Test
    public void anyLiveCellWithThreeNeighbours_livesInNextGeneration() throws Exception {
        sut.alive(0, 1);
        sut.alive(1, 0);
        sut.alive(1, 1);
        sut.alive(1, 2);

        boolean[][] cells = sut.nextGeneration();

        assertThat(cells[1][1], is(true));
    }

    @Test
    public void anyDeadCellWithExactlyThreeLiveNeighbours_becomeALiveCell() throws Exception {
        sut.alive(0, 1);
        sut.alive(1, 0);
        sut.alive(1, 2);

        boolean[][] cells = sut.nextGeneration();

        assertThat(cells[1][1], is(true));
    }

    private void assertThatAllCellsAreDeath(boolean[][] cells) {
        for (boolean[] row : cells) {
            for (boolean cell : row) {
                assertThat(cell, is(false));
            }
        }
    }
}
