package gameoflife;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length != 1) {
            System.out.println("The file path with starting points is mandatory.");
            System.exit(0);
        }

        Path filePath = Paths.get(args[0]);

        boolean[][] cells = readContentFromFile(filePath);
        GameOfLife gameOfLife = new GameOfLife(cells);

        while (true) {
            Runtime.getRuntime().exec("clear");
            printCells(cells);
            cells = gameOfLife.nextGeneration(cells);
            Thread.sleep(500);
        }
    }

    private static boolean[][] readContentFromFile(Path filePath) throws IOException {
        List<String> content = Files.readAllLines(filePath, Charset.forName("UTF-8"));
        boolean[][] cells = new boolean[content.size()][content.size()];
        int row = 0;
        for (String line : content) {
            String[] cellsString = line.split("\\s");
            for (int i = 0; i < cellsString.length; i++) {
                String cell = cellsString[i].trim();
                if (cell.equals("*")) {
                    cells[row][i] = true;
                }
            }
            row++;
        }
        return cells;
    }

    private static void printCells(boolean[][] cells) {
        for (boolean[] cellRow : cells) {
            for (boolean cell : cellRow) {
                if (cell)
                    System.out.print("*");
                else
                    System.out.print(".");
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
