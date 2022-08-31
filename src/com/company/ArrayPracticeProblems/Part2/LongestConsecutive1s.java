package com.company.ArrayPracticeProblems.Part2;

// https://leetcode.com/problems/move-zeroes/
public class LongestConsecutive1s {
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 0, 1, 1, 1, 1, 0, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    static int findMaxConsecutiveOnes(int[] nums) {
        int current = 0, max = 0;
        for (int num : nums) {
            current += num;
            if (num == 0) {
                current = 0;
            }else {
                max = Math.max(current, max);
            }
        }
        return max;
    }
}
