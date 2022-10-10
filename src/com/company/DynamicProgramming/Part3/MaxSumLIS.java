package com.company.DynamicProgramming.Part3;

import java.util.ArrayList;
import java.util.List;

public class MaxSumLIS {
    public static void main(String[] args) {
        int[] arr = {1, 101, 2, 3, 100, 4, 5};
        System.out.println(maxSumLIS(arr));
    }

    static int maxSumLIS(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }
        int ans = 0;
        for (int e : dp) ans = Math.max(ans, e);
        return ans;
    }

    static List<Integer> maxSumSequence(int n, int[] arr) {
        int[] dp = new int[n];
        List<Integer> ans = new ArrayList<>();
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }

        return ans;
    }
}
