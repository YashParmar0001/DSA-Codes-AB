package com.company.DynamicProgramming.Basics;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 4, 5};
        int amount = 10;
        System.out.println(coinChange1(coins, amount));
    }

    // Using DP
    static int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        coinsDP(coins, amount, dp);
        return (dp[amount] >= 0) ? dp[amount] : -1;
    }

    static int coinsDP(int[] coins, int amount, int[] dp) {
        if (amount < 0) return Integer.MAX_VALUE;
        if (dp[amount] != -1) return dp[amount];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int next = coinsDP(coins, amount-coin, dp);
            if (next >= 0) {
                min = Math.min(min, next);
            }
        }
        return dp[amount] = min + 1;
    }

    // Simple recursion function
    static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            min = Math.min(min, coinChange(coins, amount - coin));
        }
        return min + 1;
    }
}
