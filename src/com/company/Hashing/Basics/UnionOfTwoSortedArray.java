package com.company.Hashing.Basics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionOfTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 3, 5, 6};
        int[] nums2 = {1, 1, 2, 3, 3, 4, 5, 5};
        System.out.println(Arrays.toString(union(nums1, nums2)));
    }

    static int[] union(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            set.add(num);
        }
        int[] ans = new int[set.size()];
        int index = 0;
        for (int num : set) {
            ans[index] = num;
            index++;
        }
        return ans;
    }
}
