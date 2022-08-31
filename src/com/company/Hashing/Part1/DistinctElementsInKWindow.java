package com.company.Hashing.Part1;

import java.util.*;

public class DistinctElementsInKWindow {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,4,2,3};
        int k = 4;
        ArrayList<Integer> ans = countDistinct1(nums, nums.length, k);
        System.out.println(ans);
    }

    static ArrayList<Integer> countDistinct(int[] nums, int n, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= nums.length-k; i++) {
            int count = 0;
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < i + k; j++) {
                if (set.add(nums[j])) count++;
            }
            ans.add(count);
        }
        return ans;
    }

    // Algorithm
    // https://practice.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1
    static ArrayList<Integer> countDistinct1(int[] nums, int n, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;
        // Putting elements of first window in map
        for (int i = 0; i < k; i++) {
            if (map.containsKey(nums[i])) {
                int temp = map.get(nums[i]);
                map.put(nums[i], temp + 1);
            }else {
                map.put(nums[i], 1);
                count++;
            }
        }
        ans.add(count);

        // Now we'll travel in remaining windows
        for (int i = k; i < nums.length; i++) {
            // Remove first element of previous window if there is only one occurrence
            if (map.get(nums[i-k]) == 1) {
                count--;
                map.remove(nums[i-k]);
            }else { // Reduce the count of first element in map
                int temp = map.get(nums[i-k]);
                map.put(nums[i-k], temp-1);
            }

            // Add new element of current window
            // If it's appearing first time set its count as 1
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
                count++;
            }else {
                int temp = map.get(nums[i]);
                map.put(nums[i], temp+1);
            }

            ans.add(count);
        }

        return ans;
    }
}
