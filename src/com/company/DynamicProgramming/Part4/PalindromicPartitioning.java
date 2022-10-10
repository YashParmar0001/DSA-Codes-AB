package com.company.DynamicProgramming.Part4;

import java.util.Arrays;

public class PalindromicPartitioning {
    public static void main(String[] args) {
        String s = "abacc";
        System.out.println(palindromicPartition(s));
    }

    static int palindromicPartition(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        int[][] dp = new int[n][n];

        for (int len = 1; len < n; len++) {
            for (int row = 0, col = len; row < n - len; row++, col++) {
                if (isPalindrome(s, row, col)) {
                    dp[row][col] = 0;
                }else {
                    dp[row][col] = Integer.MAX_VALUE;
                    for (int k = row; k < col; k++) {
                        dp[row][col] = Math.min(dp[row][col], dp[row][k]+dp[k+1][col]+1);
                    }
                }
            }
        }
        for (int[] row : dp) System.out.println(Arrays.toString(row));
        return dp[0][n-1];
    }

    static boolean isPalindrome(char[] s, int i, int j) {
        while (i < j) {
            if (s[i] != s[j]) return false;
            i++; j--;
        }
        return true;
    }
}
