package com.company.ArrayPracticeProblems.Part4;

import java.util.Arrays;

// https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
public class FindMaximum_j_i {
    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 7, 2, 8, 6, 3, 4};
        System.out.println(findMaximum1(arr));
    }

    // Time : O(n^2)
    static int findMaximum(int[] arr) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    ans = Math.max(j-i, ans);
                }
            }
        }
        return ans;
    }

    // Time : O(n), Space : O(n)
    static int findMaximum1(int[] arr) {
        int[] leftMin = new int[arr.length];
        int[] rightMax = new int[arr.length];

        leftMin[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            // We need minimum element (arr[j] > arr[i]) from left side
            leftMin[i] = Math.min(leftMin[i-1], arr[i]);
        }
        System.out.println(Arrays.toString(leftMin));

        rightMax[rightMax.length-1] = arr[arr.length-1];
        for (int i = arr.length - 2; i >= 0; i--) {
            // We need maximum element (arr[j] > arr[i]) from right side
            rightMax[i] = Math.max(rightMax[i+1], arr[i]);
        }
        System.out.println(Arrays.toString(rightMax));

        int i = 0, j = 0;
        int ans = Integer.MIN_VALUE;

        while (i < arr.length && j < arr.length) {
            if (leftMin[i] < rightMax[j]) {
                ans = Math.max(ans, j - i);
                j++;
            }else {
                i++;
            }
        }

        return ans;
    }
}
