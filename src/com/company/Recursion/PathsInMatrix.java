package com.company.Recursion;

public class PathsInMatrix {
    public static void main(String[] args) {
        System.out.println(countPaths(51, 9));
    }

    static int countPaths(int row, int column) {
        if (row == 1 || column == 1) return 1;

        int rightSide = countPaths(row, column - 1);
        int leftSide = countPaths(row - 1, column);

        return rightSide + leftSide;
    }
}
