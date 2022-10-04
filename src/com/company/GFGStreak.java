package com.company;

import java.util.Arrays;

public class GFGStreak {
    public static void main(String[] args) {
        int m = 5, n = 5; // 690285631
        System.out.println(numberOfPaths(m, n));
    }

    static long numberOfPaths(int m, int n) {
        long[][] dp = new long[m+1][n+1];
        numberOfPaths5(m, n, dp);

        for (int i = 0; i<m+1; i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[m][n];
    }

    static void numberOfPaths5(int m, int n, long[][] dp){
        if (dp[m][n] != 0){
            return;
        }
        if (m == 1 && n == 1) {
            dp[m][n] = 1;
            return;
        }
        if (m < 1) return ;
        if (n < 1) return ;
        numberOfPaths5(m-1, n, dp);
        numberOfPaths5(m, n-1, dp );
        dp[m][n] = (dp[m-1][n]%1000000007 + dp[m][n-1]%1000000007)%1000000007;
    }
}
