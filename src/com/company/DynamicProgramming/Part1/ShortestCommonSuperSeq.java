package com.company.DynamicProgramming.Part1;

public class ShortestCommonSuperSeq {
    public static void main(String[] args) {
        String s1 = "abac";
        String s2 = "cab";
        System.out.println(shortestCommonSupersequence(s1, s2));
    }

    static String shortestCommonSupersequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int len = s1.length() + s2.length() - dp[m][n];
        char[] str = new char[len];
        while (m > 0 && n > 0) {
            char current;
            if (s1.charAt(m-1) == s2.charAt(n-1)) {
                current = s1.charAt(m-1);
                m--; n--;
            }else {
                if (dp[m-1][n] > dp[m][n-1]) {
                    current = s1.charAt(m-1);
                    m--;
                }else {
                    current = s2.charAt(n-1);
                    n--;
                }
            }
            str[len-1] = current;
            len--;
        }

        while (m > 0) {
            str[len-1] = s1.charAt(m-1);
            len--; m--;
        }

        while (n > 0) {
            str[len-1] = s2.charAt(n-1);
            len--; n--;
        }
        return new String(str);
    }
}
