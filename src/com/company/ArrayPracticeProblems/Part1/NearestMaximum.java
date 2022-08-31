package com.company.ArrayPracticeProblems.Part1;

import java.util.Arrays;

public class NearestMaximum {
    public static void main(String[] args) {
        int[] arr  = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        // [3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1, 1]
        replaceWithNearest1(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void replaceWithNearest(int[] arr) {
        int max = 0;
        int i = arr.length - 1;

        while (i >= 0) {
            if (max < arr[i]) {
                int temp = arr[i];
                arr[i] = max;
                max = temp;
            }else {
                arr[i] = max;
            }
            i--;
        }
    }

    static void replaceWithNearest1(int[] nums) {
        int max = 0;
        int i = nums.length-1;
        while (i >= 0) {
            int temp = nums[i];
            nums[i] = max;
            max = Math.max(max, temp);
            i--;
        }
    }
}
