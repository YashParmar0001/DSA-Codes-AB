package com.company.DynamicProgramming.Part3;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {1, 101, 2, 3, 100, 4, 5};
        System.out.println(lengthOfLIS(nums));
    }

    static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int ans = 0;
        for (int e : dp) {
            ans = Math.max(ans, e);
        }
        return ans;
    }
}