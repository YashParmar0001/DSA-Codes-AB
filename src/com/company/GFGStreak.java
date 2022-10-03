package com.company;

import java.util.*;

public class GFGStreak {
    public static void main(String[] args) {
        int[] arr = {2, 3, -1, 2, -2, 4, 1, 2, -1, -1};
        System.out.println(goodStones(arr.length, arr));
    }

    public static int goodStones(int n, int[] arr) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        for (int i = 0; i < n; i++) {
            goodStonesDP(i, arr, dp);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > 0) ans++;
        }
        return ans;
    }

    static int goodStonesDP(int current, int[] arr, int[] dp) {
        if (current < 0 || current >= arr.length) return 1;
        else if (dp[current] >= 0) return dp[current];

        dp[current] = 0;
        dp[current] += goodStonesDP(current + arr[current], arr, dp);
        return dp[current];
    }
}
