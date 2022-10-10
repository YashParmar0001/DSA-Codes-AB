package com.company.DynamicProgramming.Part1;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "babbb";
        System.out.println(longestPalindromeSubseq(s));
    }

    static int longestPalindromeSubseq(String s) {
        StringBuilder s2 = new StringBuilder(s);
        int[][] dp = new int[s.length()+1][s.length()+1];
        return lcs(s, s2.reverse().toString(), s.length(), s2.length(), dp);
    }

    static int lcs(String s1, String s2, int m, int n, int[][] dp) {
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
