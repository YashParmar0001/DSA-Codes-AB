package com.company.ArrayPracticeProblems.GFGSheet;

// https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
public class MinimumPlatforms {
    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arr, dep, arr.length));
    }

    static int findPlatform(int[] arr, int[] dep, int n) {
        int[] time = new int[2361];
        for (int i = 0; i < n; i++) {
            time[arr[i]]++;
            time[dep[i]+1]--;
        }
        for (int i = 1; i < 2361; i++) {
            time[i] += time[i-1];
        }
        int ans = time[0];
        for (int i = 0; i < 2361; i++) {
            ans = Math.max(ans, time[i]);
        }
        return ans;
    }
}
