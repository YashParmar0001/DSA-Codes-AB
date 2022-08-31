package com.company.Recursion.Backtracking;

public class NQueens {
    public static void main(String[] args) {
        boolean[][] chess = new boolean[4][4];
        System.out.println(nQueens(chess, 0));
    }

    // Explanation : 01:41:45
    static boolean nQueens(boolean[][] chess, int row) {
        if (row == chess.length) {
            for (boolean[] booleans : chess) {
                for (int j = 0; j < chess.length; j++) {
                    if (booleans[j]) System.out.print("Q ");
                    else System.out.print("X ");
                }
                System.out.println();
            }
            return true;
        }

        for (int column = 0; column < chess.length; column++) {
            if (isSafe(chess, row, column)) {
                chess[row][column] = true;
                if (nQueens(chess, row + 1)) {
                    return true;
                }
                // Backtracking
                chess[row][column] = false;
            }
        }
        return false;
    }

    static boolean isSafe(boolean[][] chess, int row, int column) {
        // Checking for column ( Queen should not be present in column )
        for (boolean[] rows : chess) {
            if (rows[column]) return false;
        }

        // Checking left diagonal
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j]) return false;
        }

        // Checking right diagonal
        for (int i = row, j = column; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j]) return false;
        }

        return true;
    }
}
