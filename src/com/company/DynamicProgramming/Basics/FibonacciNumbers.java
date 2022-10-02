package com.company.DynamicProgramming.Basics;

import java.util.Arrays;

public class FibonacciNumbers {
    public static void main(String[] args) {
        System.out.println(fibonacci(3));
    }

    static int fibonacci(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        fibDP(n, dp);
        return dp[n];
    }

    static int fibDP(int n, int[] dp) {
        if (dp[n] != -1) return dp[n];

        return dp[n] = fibDP(n-1, dp) + fibDP(n-2, dp);
    }
}
