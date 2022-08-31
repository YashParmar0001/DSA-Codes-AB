package com.company.ArrayPracticeProblems.Part4;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 7, 8, 10, 12};
        System.out.println(Arrays.toString(twoSum(arr, 12)));
    }

    static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i, j};
            }else if (numbers[i] + numbers[j] > target) {
                j--;
            }else {
                i++;
            }
        }
        return new int[]{-1, -1};
    }
}
