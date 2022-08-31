package com.company.Mathematics_.Basics;

public class UniquePathsInGrid {
    public static void main(String[] args) {
        int[][] grid = new int[3][3];
        System.out.println(findPaths(grid));
    }

    static int findPaths(int[][] grid) {
        int m = grid.length - 1;
        int n = grid[0].length - 1;

        int ans = m + 1;

        for (int i = 2; i <= n; i++) {
            ans *= (m + i) / i;
        }

        return ans;
    }
}
