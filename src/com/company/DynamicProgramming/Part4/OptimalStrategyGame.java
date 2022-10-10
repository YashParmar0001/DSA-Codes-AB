package com.company.DynamicProgramming.Part4;

import java.util.Arrays;

public class OptimalStrategyGame {
    public static void main(String[] args) {
        int[] coins = {1, 10, 2, 10, 100, 30};
        System.out.println(maximumAmount(coins, coins.length));
        System.out.println(maximumAmountTabular(coins, coins.length));
    }

    static long maximumAmount(int[] coins, int n) {
        long[][] dp = new long[n][n];
        for (long[] row : dp) Arrays.fill(row, -1);
        maximumAmount(coins, 0, n-1, dp);
        return dp[0][n-1];
    }

    static long maximumAmount(int[] coins, int i, int j, long[][] dp) {
        if (i + 1 == j) return dp[i][j] = Math.max(coins[i], coins[j]);
        if (dp[i][j] != -1) return dp[i][j];

        long left = coins[i] + Math.min(maximumAmount(coins, i+2, j, dp), maximumAmount(coins, i+1, j-1, dp));
        long right = coins[j] + Math.min(maximumAmount(coins, i+1, j-1, dp), maximumAmount(coins, i, j-2, dp));

        return dp[i][j] = Math.max(left, right);
    }

    static long maximumAmountTabular(int[] coins, int n) {
        long[][] dp = new long[n][n];
        for (int len = 1; len < n; len+=2) {
            for (int row = 0, col = len; row < n - len; row++, col++) {
                if (row + 1 == col) {
                    dp[row][col] = Math.max(coins[row], coins[col]);
                }else {
                    dp[row][col] = Math.max(coins[row] + Math.min(dp[row+2][col], dp[row+1][col-1]),
                            coins[col] + Math.min(dp[row+1][col-1], dp[row][col-2]));
                }
            }
        }
//        for (long[] row : dp) System.out.println(Arrays.toString(row));
        return dp[0][n-1];
    }
}
