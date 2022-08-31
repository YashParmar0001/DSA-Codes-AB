package com.company.ArrayPracticeProblems.Part3;

import java.util.Arrays;

// https://leetcode.com/problems/rotate-array/
public class RotateArrayByK {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    // Explanation :
    // https://leetcode.com/problems/rotate-array/discuss/54250/Easy-to-read-Java-solution
    static void rotate(int[] nums, int k) {
        // For the cases like :
        // [1, 2, 3], k = 4 --> After 3rd rotation --> [1, 2, 3] and 1 remains (4 % 3 = 1)
        k = k % nums.length;

        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
