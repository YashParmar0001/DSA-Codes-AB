package com.company;

import java.util.*;

public class LeetCodeStreak {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[][] queries = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        System.out.println(Arrays.toString(sumEvenAfterQueries(nums, queries)));
    }

    static int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        nums[queries[0][1]] = nums[queries[0][1]] + queries[0][0];
        int[] ans = new int[nums.length]; int index = 1;
        int sum = 0;
        for (int e : nums) {
            if (e % 2 == 0) {
                sum += e;
            }
        }
        ans[0] = sum;
        for (int i = 1; i < queries.length; i++) {
            int[] querie = queries[i];
            int n = nums[querie[1]];
            nums[querie[1]] = nums[querie[1]] + querie[0];
            if (n % 2 == 0) {
                if (nums[querie[1]] % 2 == 0) {
                    sum -= n;
                    sum += nums[querie[1]];
                }else {
                    sum -= n;
                }
            }else {
                if (nums[querie[1]] % 2 == 0) sum += nums[querie[1]];
            }
            ans[index] = sum;
            index++;
        }
        return ans;
    }
}