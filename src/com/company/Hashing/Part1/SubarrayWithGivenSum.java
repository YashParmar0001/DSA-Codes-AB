package com.company.Hashing.Part1;

import java.util.*;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4, 5, 7, 6, 3};
        int target = 7;
        System.out.println(Arrays.toString(subarrayWithSum(nums, target)));
    }

    // Explanation
    // https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/
    static int[] subarrayWithSum(int[] nums, int target) {
        int currSum = 0;
        int start = 0, end = -1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];

            if (currSum - target == 0) {
                start = 0;
                end = i;
                break;
            }

            if (map.containsKey(currSum-target)) {
                start = map.get(currSum-target) + 1;
                end = i;
                break;
            }

            map.put(currSum, i);
        }

        if (end == -1) return new int[]{-1};
        else {
            int[] ans = new int[end-start+1];
            for (int i = start; i <= end; i++) {
                ans[i-start] = nums[i];
            }
            return ans;
        }
    }
}
