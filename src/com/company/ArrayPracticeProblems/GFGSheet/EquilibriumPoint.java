package com.company.ArrayPracticeProblems.GFGSheet;

import java.util.Arrays;

public class EquilibriumPoint {
    public static void main(String[] args) {
        long[] arr = {1,3,5,2,2};
        System.out.println(equilibriumPoint(arr, arr.length));
    }

    static int equilibriumPoint(long arr[], int n) {
        long[] leftSum = new long[arr.length];
        leftSum[0] = arr[0];
        long[] rightSum = new long[arr.length];
        rightSum[rightSum.length-1] = arr[arr.length-1];
        for (int i = 1; i < arr.length; i++) {
            leftSum[i] = leftSum[i-1] + arr[i];
        }
        for (int i = arr.length-2; i >= 0; i--) {
            rightSum[i] = rightSum[i+1] + arr[i];
        }
        System.out.println(Arrays.toString(leftSum));
        System.out.println(Arrays.toString(rightSum));
        for (int i = 0; i < arr.length; i++) {
            if (leftSum[i] == rightSum[i]) return i+1;
        }
        return -1;
    }
}
