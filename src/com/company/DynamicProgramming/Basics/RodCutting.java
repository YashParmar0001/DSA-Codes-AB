package com.company.DynamicProgramming.Basics;

import java.util.Arrays;

public class RodCutting {
    public static void main(String[] args) {
        int n = 8;
        int[] prices = {3, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(prices, n));
    }

    static int cutRod(int[] price, int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        cutRodDP(price, n, dp);
        return dp[n];
    }

    static int cutRodDP(int[] prices, int n, int[] dp) {
        if (n < 0) return Integer.MIN_VALUE;
        if (dp[n] != -1) return dp[n];

        int max = -1;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, prices[i] + cutRodDP(prices, n - i - 1, dp));
        }
        return dp[n] = max;
    }

    // Simple recursion
    static int rodCutting(int[] prices, int n) {
        if (n == 0) return 0;
        if (n < 0) return Integer.MIN_VALUE;

        int max = -1;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, prices[i] + rodCutting(prices, n - i - 1));
        }
        return max;
    }
}
