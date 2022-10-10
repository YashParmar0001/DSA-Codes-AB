package com.company.DynamicProgramming.Part1;

import java.util.Arrays;

public class MinInsertDelete {
    public static void main(String[] args) {
        String s1 = "heap";
        String s2 = "pea";
        System.out.println(minOperations(s1, s2));
    }

    static int minOperations(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int len = lcs(str1, str2, str1.length(), str2.length(), dp);
        return str1.length() + str2.length() - 2 * len;
    }

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
