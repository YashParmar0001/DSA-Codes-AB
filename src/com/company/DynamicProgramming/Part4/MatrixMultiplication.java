package com.company.DynamicProgramming.Part4;

import java.util.Arrays;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 1, 3};
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];
        for (int[] row : dp) Arrays.fill(row, -1);
        System.out.println(matrixMultiplicationRec(arr, 1, n-1, dp));
//        System.out.println(matrixMultiplication(n, arr));
    }

    static int matrixMultiplication(int n, int[] arr) {
        int[][] dp = new int[n][n];

        for (int len = 2; len < n; len++) {
            for (int row = 0, col = len; row < n - len; row++, col++) { // This is for travelling diagonal
                dp[row][col] = Integer.MAX_VALUE;
                for (int k = row + 1; k < col; k++) { // This is for applying cuts
                    dp[row][col] = Math.min(dp[row][col], dp[row][k]+dp[k][col]+arr[row]*arr[k]*arr[col]);
                }
            }
        }

//        for (int[] row : dp) System.out.println(Arrays.toString(row));

        return dp[0][n-1];
    }

    static int matrixMultiplicationRec(int[] arr, int row, int col, int[][] dp) {
        if (row >= col) return 0;
        if (dp[row][col] != -1) return dp[row][col];
        int ans = Integer.MAX_VALUE;
        for (int k = row; k < col; k++) {
            ans = Math.min(ans, matrixMultiplicationRec(arr, row, k, dp) +
                    matrixMultiplicationRec(arr, k+1, col, dp) + arr[row-1] * arr[k] * arr[col]);
        }
        return dp[row][col] = ans;
    }
}
