package com.company.DynamicProgramming.Part2;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "cat";
        String s2 = "cut";
        System.out.println(minDistance(s1, s2));
    }

    static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
//        for (int[] row : dp) Arrays.fill(row, -1);
        return minDistanceTabular(word1, word2, m, n, dp);
    }

    // Top-down dp
    static int minDistanceRecursion(String s1, String s2, int m, int n, int[][] dp) {
        if (m == 0) return n;
        if (n == 0) return m;

        if (dp[m][n] != -1) return dp[m][n];

        if (s1.charAt(m-1) == s2.charAt(n-1)) {
            return dp[m][n] = minDistanceRecursion(s1, s2, m-1, n-1, dp);
        }else {
            return dp[m][n] = Math.min(Math.min(minDistanceRecursion(s1, s2, m-1, n, dp),
                    minDistanceRecursion(s1, s2, m, n-1, dp)
            ), minDistanceRecursion(s1, s2, m-1, n-1, dp)) + 1;
        }
    }

    // Bottom-up dp
    static int minDistanceTabular(String s1, String s2, int m, int n, int[][] dp) {
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
