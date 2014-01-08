package main;

import gameoflife.GameOfLife;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class TableContainer extends JPanel {
    private final boolean DEBUG = true;
    private final GameOfLife gameOfLife;
    private final MyTableModel tableModel;

    public TableContainer(GameOfLife gameOfLife) {
        super(new GridLayout(1, 0));
        this.gameOfLife = gameOfLife;

        tableModel = new MyTableModel();
        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setTableHeader(null);
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    public void updateTableContent(boolean[][] booleans) {
        tableModel.fireTableDataChanged();
    }

    class MyTableModel extends AbstractTableModel {
        public int getColumnCount() {
            return 4;
        }

        public int getRowCount() {
            return 4;
        }

        public Object getValueAt(int row, int col) {
            return gameOfLife.getCell(row, col);
        }

        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        public boolean isCellEditable(int row, int col) {
            return true;
        }

        public void setValueAt(Object value, int row, int col) {
            boolean cell = (boolean) value;
            if (cell)
                gameOfLife.alive(row, col);
            else
                gameOfLife.dead(row, col);
            fireTableCellUpdated(row, col);

            if (DEBUG) {
                System.out.println("New value of data:");
                printDebugData();
            }
        }

        private void printDebugData() {
            int numRows = getRowCount();
            int numCols = getColumnCount();

            for (int i = 0; i < numRows; i++) {
                System.out.print("    row " + i + ":");
                for (int j = 0; j < numCols; j++) {
                    System.out.print("  " + gameOfLife.getCell(i, j));
                }
                System.out.println();
            }
            System.out.println("--------------------------");
        }
    }
}