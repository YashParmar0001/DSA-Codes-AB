package com.company.Hashing.Part1;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] nums = {2, 1, 9, 3, 5, 4, 8, 7, 2, 1, 3};
        System.out.println(longestConsecutive(nums));
    }

    static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int element : nums) set.add(element);
        int ans = 0;
        for (int element : set) { // To avoid duplicates we can iterate into set
            if (!set.contains(element-1)) { // Means it's starting of subsequence
                int length = 1;
                while (set.contains(++element)) {
                    length++;
                }
                ans = Math.max(ans, length);
            }
        }
        return ans;
    }
}
