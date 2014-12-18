package queens.puzzle;

import org.junit.Test;

public class QueensPuzzleTest {
    @Test
    public void test8QueenPuzzle() throws Exception {
        QueensPuzzle  queensPuzzle = new QueensPuzzle(8);

        queensPuzzle.compute();

        for (boolean[][] solution : queensPuzzle.getSolutions()) {
            print(solution);
        }

        System.out.println("Number of solutions found:" + queensPuzzle.getSolutions().size());
    }

    private void print(boolean[][] solution) {
        System.out.println("Solution:");
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[i].length; j++) {
                System.out.print((solution[i][j] ? "1" : "0") + " ");
            }
            System.out.println("");
        }
    }
}