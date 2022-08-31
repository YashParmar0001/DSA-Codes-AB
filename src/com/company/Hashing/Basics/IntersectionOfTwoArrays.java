package com.company.Hashing.Basics;

import java.util.*;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    static int[] intersect(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> ansSet = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (!set.add(num)) {
                ans.add(num);
            }
        }
        int[] ans_ = new int[ans.size()];
        for (int i = 0; i < ans_.length; i++) {
            ans_[i] = ans.get(i);
        }
        return ans_;
    }
}
