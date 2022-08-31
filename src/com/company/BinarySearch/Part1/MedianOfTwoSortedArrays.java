package com.company.BinarySearch.Part1;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {2, 3, 5, 6, 7, 9, 10, 11};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int left = 0, right = n1;
        while (left <= right) {
            int m1 = left + (right-left)/2;
            int m2 = (n1+n2+1)/2 - m1;

            int max1 = (m1 == 0) ? Integer.MIN_VALUE : nums1[m1-1];
            int max2 = (m2 == 0) ? Integer.MIN_VALUE : nums2[m2-1];

            int min1 = (m1 == n1) ? Integer.MAX_VALUE : nums1[m1];
            int min2 = (m2 == n2) ? Integer.MAX_VALUE : nums2[m2];

            if (max1 <= min2 && max2 <= min1) {
                if ((n1+n2)%2 == 0) {
                    return ((double) Math.max(max1, max2) + (double) Math.min(min1, min2)) / 2;
                }else {
                    return (double) Math.max(max1, max2);
                }
            }else if (max2 > min1) {
                left = m1 + 1;
            }else if (max1 > min2) {
                right = m1 - 1;
            }
        }

        return 0.0;
    }
}
