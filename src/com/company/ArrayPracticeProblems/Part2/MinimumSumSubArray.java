package com.company.ArrayPracticeProblems.Part2;

// https://practice.geeksforgeeks.org/problems/smallest-sum-contiguous-subarray/1/
public class MinimumSumSubArray {
    public static void main(String[] args) {
        int[] a = {2, 6, 8, 1, 4};
        System.out.println(smallestSumSubarray(a, a.length));
    }

    static int smallestSumSubarray(int a[], int size) {
        int currSum = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;

        for (int num : a) {
            if (currSum > 0) {
                currSum = num;
            }else {
                currSum += num;
            }
            minSum = Math.min(currSum, minSum);
        }

        return minSum;
    }
}
