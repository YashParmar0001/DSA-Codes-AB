package com.company;

import java.util.Arrays;

public class LeetCodeStreak {
    public static void main(String[] args) {
        int n = 30, k = 30, target = 500;
        System.out.println(numRollsToTarget(n, k, target));
    }

    // Simple recursion
//    static int numRollsToTarget(int n, int k, int target) {
//        if (n == 0) {
//            if (target == 0) ans++;
//            return 0;
//        }
//        for (int i = 1; i <= k; i++) {
//            numRollsToTarget(n-1, k, target-i);
//        }
//        return ans;
//    }

    static int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][target+1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return numRollsDP(n, k, target, dp);
    }

    static int numRollsDP(int n, int k, int target, int[][] dp) {
        // Base case
        if (n == 0 || target < 0) return (target == 0) ? 1 : 0;

        if (dp[n][target] != -1) return dp[n][target];

        int ways = 0;
        for (int i = 1; i <= k; i++) {
            ways = (ways + numRollsDP(n-1, k, target-i, dp)) % 1000000007;
        }
        return dp[n][target] = ways;
    }
}