package com.company.ArrayPracticeProblems.Part3;

import java.util.Arrays;

// https://leetcode.com/problems/majority-element/
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement1(nums));
    }

    // O(n) --> Using Hashmap

    // O(nlogn) --> Sorting the array
    static int majorityElement(int[] nums) {
        Arrays.sort(nums);

        int current = nums[0];
        int count = 0;

        for (int num : nums) {

            if (count > nums.length / 2) return current;

            if (num == current) {
                count++;
            }else {
                count = 1;
                current = num;
            }
        }

        if (count > nums.length / 2) return current;
        return -1;
    }

    // O(nlogn) --> Optimized
    static int majorityElement1(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length/2];
    }
}
