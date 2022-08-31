package com.company.ArrayPracticeProblems.Part2;

import java.util.Arrays;

// https://leetcode.com/problems/move-zeroes/
public class Move0sToRight {
    public static void main(String[] args) {
        int[] nums = {8, 0, 1, 3, 0, 0, 5};
        moveZeroes1(nums);
        System.out.println(Arrays.toString(nums));
    }

    // Time : O(n), Space : O(n)
    static void moveZeroes(int[] nums) {
        int[] ans = new int[nums.length];
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                ans[index] = num;
                index++;
            }
        }
        System.arraycopy(ans, 0, nums, 0, ans.length);
    }

    // Time : O(n), Space : O(1)
    static void moveZeroes1(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
