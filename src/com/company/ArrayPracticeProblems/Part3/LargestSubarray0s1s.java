package com.company.ArrayPracticeProblems.Part3;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/contiguous-array/solution/
public class LargestSubarray0s1s {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 0, 0};
        System.out.println(findMaxLength(arr));
    }

    static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count += 1;
            }else count -= 1;

            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            }else {
                map.put(count, i);
            }
        }

        return maxLen;
    }

    static int maxLen1(int[] arr, int N) {
       int i = 0, j = 1;
       int balance = 0;
       int ans = Integer.MIN_VALUE, length;

       while (i < arr.length) {
           if (arr[i] == 0) {
               balance--;
           }else balance++;

           if (balance == 0) {
               ans = Math.max(ans, i + 1);
           }

           i++;
       }
       return ans;
    }
}
