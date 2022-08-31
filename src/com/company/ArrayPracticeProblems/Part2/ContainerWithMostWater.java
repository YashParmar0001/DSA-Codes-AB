package com.company.ArrayPracticeProblems.Part2;

// https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
        System.out.println(maxArea1(height));
    }

    // Time complexity : O(n^2) and Theta(n)
    // two pointer approach
    static int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int left = height[i];
                int right = height[j];
                int dist = j - i;
                int area = Math.min(left, right) * dist;
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    static int maxArea1(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int left = height[i], right = height[j];
            int dist = j - i;
            int area = Math.min(left, right) * dist;
            maxArea = Math.max(area, maxArea);

            if (left < right) i++;
            else j--;
        }
        return maxArea;
    }
}
