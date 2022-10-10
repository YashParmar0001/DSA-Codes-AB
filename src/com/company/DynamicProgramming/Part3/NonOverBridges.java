package com.company.DynamicProgramming.Part3;

import java.util.Arrays;

public class NonOverBridges {
    public static void main(String[] args) {
        int[][] bridges = {{0, 2}, {1, 1}, {2, 7}, {3, 4}, {4, 5}, {5, 8}, {6, 7}};
        System.out.println(maxNonOverlappingBridges(bridges));
    }

    static int maxNonOverlappingBridges(int[][] bridges) {
        Arrays.sort(bridges, (a, b) -> {
            if (a[0] == b[0]) return a[1]-b[1];
            else return a[0]-b[0];
        });
        int[] end = new int[bridges.length];
        int index = 0;
        for (int[] bridge : bridges) {
            end[index++] = bridge[1];
        }
        return lengthOfLIS(end);
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
