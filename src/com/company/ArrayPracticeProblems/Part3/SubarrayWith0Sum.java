package com.company.ArrayPracticeProblems.Part3;

import java.util.HashSet;
import java.util.Set;

// https://practice.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1/#
public class SubarrayWith0Sum {
    public static void main(String[] args) {
        int[] arr = {4, 5, -3, -6, 5, 4};
//        System.out.println(findSum(arr, arr.length));
        System.out.println(findSum1(arr, arr.length));
    }

    // Checking all the possible sub-arrays
    // Time : O(n^3)
    static boolean findSum(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum == 0) {
                    return true;
                }else sum = 0;
            }
        }
        return false;
    }

    // Using prefix sum method
    // Time : O(n)
    static boolean findSum1(int[] arr, int n) {
        int[] prefixSum = new int[arr.length];
        Set<Integer> check = new HashSet<>();
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
            if (prefixSum[i] == 0) return true;
        }
        for (int num : prefixSum) {
            if (!check.add(num)) {
                return true;
            }
        }
//        System.out.println(Arrays.toString(prefixSum));
        return false;
    }


}
