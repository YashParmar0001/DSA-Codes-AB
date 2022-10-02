package com.company.DynamicProgramming.Part1;

import java.util.Arrays;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        System.out.println(longestCommonSubsequence(s1, s2));
        System.out.println(match.toString());
    }

    static int longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        // This loop is for recursive dp
//        for (int[] row : dp) {
//            Arrays.fill(row, -1);
//        }
        return lcsTabular(s1, s2, s1.length(), s2.length(), dp);
    }

    static StringBuilder match = new StringBuilder();
    // bottom up approach in dp (tabular)
    static int lcsTabular(String s1, String s2, int m, int n, int[][] dp) {
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    match.append(s1.charAt(i-1));
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    // Top - down approach (Recursive)
    static int lcs(String s1, String s2, int m, int n, int[][] dp) {
        if (m == 0 || n == 0) return 0;

        if (dp[m][n] != -1) return dp[m][n];

        if (s1.charAt(m-1) == s2.charAt(n-1)) {
            return dp[m][n] = lcs(s1, s2, m-1, n-1, dp) + 1;
        }else {
            return dp[m][n] = Math.max(lcs(s1, s2, m-1, n, dp), lcs(s1, s2, m, n-1, dp));
        }
    }
}
