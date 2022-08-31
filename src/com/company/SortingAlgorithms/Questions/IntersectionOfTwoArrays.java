package com.company.SortingAlgorithms.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {2, 5, 6, 6, 8, 8};
        int[] nums2 = {1, 1, 2, 3, 6, 9};
        List<Integer> ans = intersection(nums1, nums2);

        System.out.println(ans);
    }

    static List<Integer> intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;

        List<Integer> list = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            // For handling duplicates
            if (i > 0 && nums1[i] == nums2[i-1]) {
                i++;
                continue;
            }

            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++; j++;
            }else if (nums1[i] > nums2[j]) {
                j++;
            }else i++;
        }

        return list;
    }
}
