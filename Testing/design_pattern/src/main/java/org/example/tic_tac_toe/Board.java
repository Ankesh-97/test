package org.example.tic_tac_toe;

public class Board {

    private int size;
    private String[][] matrix;

    public Board(int size) {
        this.size = size;
        this.matrix = new String[size][size];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean addSymbol(String val, int row, int col) {
        if (row < 0 && row >= this.size) {
            return false;
        }
        if (col < 0 && col >= this.size) {
            return false;
        }
        if (this.matrix[row][col] != null) {
            return false;
        }
        this.matrix[row][col] = val;
        return true;
    }

    public boolean checkWinner(int row, int col) {

        boolean isRowSame = checkRow(row, col);
        boolean isColSame = checkRow(row, col);
        boolean isDiagonalSame = false;
        boolean isReverseDiagonalSame = false;

        if (row == col) {
            isDiagonalSame = checkDiagonal(row, col);
        }
        if (row + col == size - 1) {
            isReverseDiagonalSame = checkReverseDiagonal(row, col);
        }

        return isRowSame || isColSame || isDiagonalSame || isReverseDiagonalSame;

    }

    private boolean checkColumn(int row, int col) {
        String val = this.matrix[row][col];
        for (int i = 0; i < size; i++) {
            String curr = this.matrix[i][col];
            if (curr == null) {
                return false;
            }
            if (!val.equals(this.matrix[i][col])) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRow(int row, int col) {
        String val = this.matrix[row][col];
        for (int i = 0; i < size; i++) {
            String curr = this.matrix[row][i];
            if (curr == null) {
                return false;
            }
            if (!val.equals(this.matrix[row][i])) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal(int row, int col) {
        String val = this.matrix[row][col];
        for (int i = 0; i < size; i++) {
            String curr = this.matrix[i][i];
            if (curr == null) {
                return false;
            }
            if (!val.equals(this.matrix[i][i])) {
                return false;
            }
        }
        return true;
    }

    private boolean checkReverseDiagonal(int row, int col) {
        String val = this.matrix[row][col];
        for (int i = 0; i < this.size; i++) {
            String curr = this.matrix[i][this.size - i - 1];
            if (curr == null) {
                return false;
            }
            if (!val.equals(this.matrix[i][this.size - i - 1])) {
                return false;
            }
        }
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j == size - 1) {
                    System.out.println(" | " + matrix[i][j] + " |");
                } else {
                    System.out.print(" | " + matrix[i][j]);
                }
            }
            System.out.println("--------------------------------------");

        }
    }
}
