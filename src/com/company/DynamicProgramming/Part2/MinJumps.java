package com.company.DynamicProgramming.Part2;

import java.util.Arrays;

public class MinJumps {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 1, 3, 5, 1, 1, 2};
        System.out.println(minJumps(arr));
    }

    static int minJumps(int[] arr) {
        int[] dp = new int[arr.length+1];
        Arrays.fill(dp, -1);
        minJumps(arr, 0, dp);
        return dp[0];
    }

    static int minJumps(int[] arr, int i, int[] dp) {
        if (i >= arr.length-1) return 0;

        if (dp[i] != -1) return dp[i];

        if (arr[i] == 0) return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= arr[i]; j++) {
            min = Math.min(min, minJumps(arr, i+j, dp)) + 1;
        }
        return dp[i] = min;
    }
}
