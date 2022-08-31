package com.company.ArrayPracticeProblems.Part2;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-subarray/
public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] arr = {6, 7, 4, -12, 1, 5, -4};
//        System.out.println(maxSubArray(new int[]{0}));
        System.out.println(Arrays.toString(maxSubArray1(arr)));
    }

    // Intuitive approach

    // Time complexity : O(n)
    static int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
//        int maxSum = nums[0];
        for (int num : nums) {
            currSum += num;
            if (currSum > maxSum) {
                maxSum = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    static int[] maxSubArray1(int[] nums) {
        int start = 0, end = 0;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (currSum > maxSum) {
                maxSum = currSum;
                end = i;
            }
            if (currSum < 0) {
                start = i;
                currSum = 0;
            }
        }

        int[] ans = new int[end - start + 1];
        int index = 0;

        for (int i = start; i <= end; i++) {
            ans[index] = nums[i];
            index++;
        }
        return ans;
    }
}
