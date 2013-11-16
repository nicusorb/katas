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
}
