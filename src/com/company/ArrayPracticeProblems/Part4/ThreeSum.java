package com.company.ArrayPracticeProblems.Part4;

import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {
        int[] A = {1, 4, 6, 8, 10, 45, 0};
        System.out.println(find3Numbers(A, A.length, 15));
    }

    static boolean find3Numbers(int A[], int n, int X) {
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (twoSum(A, X - A[i], i)) return true;
        }
        return false;
    }

    static boolean twoSum(int[] numbers, int target, int index) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (i == index) i++;
            if (j == index) j--;
            if (numbers[i] + numbers[j] == target) {
                return true;
            }else if (numbers[i] + numbers[j] > target) {
                j--;
            }else i++;
         }
        return false;
    }
}
