package com.company.DynamicProgramming.Part4;

public class CountBSTNKeys {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(numTrees(n));
    }

    static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int result = 0;
            for (int j = 0; j < i; j++) {
                result += dp[j] * dp[i-j-1];
            }
            dp[i] = result;
        }
        return dp[n];
    }
}
