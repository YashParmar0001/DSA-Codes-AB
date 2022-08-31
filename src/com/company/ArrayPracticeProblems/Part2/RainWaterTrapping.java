package com.company.ArrayPracticeProblems.Part2;

import java.util.Arrays;

// https://leetcode.com/problems/trapping-rain-water/
public class RainWaterTrapping {
    public static void main(String[] args) {
        System.out.println(trap1(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    // Time : O(n), Space : O(n)
    static int trap(int[] height) {
        int ans = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        System.out.println(Arrays.toString(leftMax));

        rightMax[rightMax.length-1] = height[height.length-1];
        for (int i = height.length-2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        System.out.println(Arrays.toString(rightMax));

        for (int i = 0; i < height.length; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return ans;
    }

    // Time : O(n), Space : O(1)
    static int trap1(int[] height) {
        int ans = 0;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] > leftMax) leftMax = height[left];
                else ans += leftMax - height[left];
                left++;
            }else {
                if (height[right] > rightMax) rightMax = height[right];
                else ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
