package com.company.ArrayPracticeProblems.GFGSheet;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {7,4,0,9};
        System.out.println(trappingWater(arr, arr.length));
    }

    static long trappingWater(int[] arr, int n) {
        int[] leftMax = new int[n]; leftMax[0] = arr[0];
        int[] rightMax = new int[n]; rightMax[n-1] = arr[n-1];
        long ans = 0;
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], arr[i]);
        }
        for (int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], arr[i]);
        }
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }
        return ans;
    }
}
