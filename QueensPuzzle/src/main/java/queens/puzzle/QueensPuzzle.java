package queens.puzzle;

import java.util.LinkedList;
import java.util.List;

public class QueensPuzzle {
    private int nbOfQueens;
    private boolean[][] chessTable;
    private List<boolean[][]> solutions = new LinkedList<>();

    public QueensPuzzle(int nbOfQueens) {
        this.nbOfQueens = nbOfQueens;
        this.chessTable = new boolean[nbOfQueens][nbOfQueens];
    }

    public List<boolean[][]> getSolutions() {
        return solutions;
    }

    public void compute() {
        bt(chessTable);
    }

    private void bt(boolean[][] chessTable) {
        if (reject(chessTable))
            return;
        if (solution(chessTable)) {
            solutions.add(clone(chessTable));
            print(chessTable);
            return;
        }

        boolean[][] candidate = first(chessTable);
        while (candidate != null) {
            bt(candidate);
            candidate = next(candidate);
        }

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

    private boolean[][] first(boolean[][] chessTable) {
        int lastRowWithQueen = -1;

        for (int i = 0; i < chessTable.length; i++) {
            for (int j = 0; j < chessTable[i].length; j++) {
                if (chessTable[i][j]) {
                    lastRowWithQueen = i;
                }
            }
        }

        if (lastRowWithQueen < nbOfQueens - 1) {
            boolean[][] candidate = clone(chessTable);
            candidate[lastRowWithQueen + 1][0] = true;

            return candidate;
        }

        return null;
    }

    private boolean[][] clone(boolean[][] chessTable) {
        boolean[][] candidate = new boolean[nbOfQueens][nbOfQueens];
        for (int i = 0; i < candidate.length; i++) {
            candidate[i] = chessTable[i].clone();
        }
        return candidate;
    }

    private boolean[][] next(boolean[][] chessTable) {
        int lastRowWithQueen = -1, lastColumnWithQueen = -1;

        for (int i = 0; i < chessTable.length; i++) {
            for (int j = 0; j < chessTable[i].length; j++) {
                if (chessTable[i][j]) {
                    lastRowWithQueen = i;
                    lastColumnWithQueen = j;
                }
            }
        }

        if (lastColumnWithQueen < nbOfQueens - 1) {
            boolean[][] candidate = clone(chessTable);
            if (lastRowWithQueen != -1)
                candidate[lastRowWithQueen][lastColumnWithQueen] = false;
            candidate[lastRowWithQueen][lastColumnWithQueen + 1] = true;

            return candidate;
        }

        return null;
    }

    private boolean solution(boolean[][] chessTable) {
        int nbOfQueensFound = 0;
        for (int i = 0; i < chessTable.length; i++) {
            for (int j = 0; j < chessTable[i].length; j++) {
                if (chessTable[i][j])
                    nbOfQueensFound++;
            }
        }
        return nbOfQueensFound == nbOfQueens;
    }

    private boolean reject(boolean[][] chessTable) {
        for (int i = 0; i < chessTable.length; i++) {
            int nbOfQueensOnRow = 0;
            for (int j = 0; j < chessTable[i].length; j++) {
                if (chessTable[i][j])
                    nbOfQueensOnRow++;
                if (nbOfQueensOnRow > 1)
                    return true;
            }
        }

        for (int i = 0; i < chessTable.length; i++) {
            int nbOfQueensOnColumn = 0;
            for (int j = 0; j < chessTable[i].length; j++) {
                if (chessTable[j][i])
                    nbOfQueensOnColumn++;
                if (nbOfQueensOnColumn > 1)
                    return true;
            }
        }

        for (int i = 0; i < chessTable.length; i++) {
            for (int j = 0; j < chessTable.length; j++) {
                if (chessTable[i][j] == true && (chessTable[j][i] == true) && (i != j))
                    return true;
            }
        }

        for (int i = 0; i < chessTable.length - 1; i++) {
            if (chessTable[i][i] == true && (chessTable[i + 1][i] == true || chessTable[i][i + 1] == true || chessTable[i + 1][i + 1] == true))
                return true;
        }

        for (int i = chessTable.length - 1; i > 0; i--) {
            if (chessTable[i][i] == true && (chessTable[i - 1][i] == true || chessTable[i][i - 1] == true || chessTable[i - 1][i - 1] == true))
                return true;
        }

        return false;
    }
}

//    procedure bt(c)
//if reject(P,c) then return
//        if accept(P,c) then output(P,c)
//        s ← first(P,c)
//        while s ≠ Λ do
//        bt(s)
//        s ← next(P,s)