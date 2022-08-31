package com.company.ArrayPracticeProblems.Part1;

// https://leetcode.com/problems/third-maximum-number/
public class ThirdLargestElement {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2};
        System.out.println(thirdMax(arr));
    }

    static int thirdMax(int[] nums) {
        // We're not using Integer.MIN_VALUE for the cases like...
        // {1,2,-2147483648};

        Integer max1 = null, max2 = null, max3 = null;

        for (Integer num : nums) {
            // For avoiding duplicates
            if (num.equals(max1) || num.equals(max2) || num.equals(max3)) continue;

            if (max1 == null || max1 < num) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            }else if (max2 == null || max2 < num) {
                max3 = max2;
                max2 = num;
            }else if (max3 == null || max3 < num) {
                max3 = num;
            }
        }

        if (max3 != null) return max3;
        else return max1;
    }
}
