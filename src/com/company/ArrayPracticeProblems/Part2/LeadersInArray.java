package com.company.ArrayPracticeProblems.Part2;

import java.util.Arrays;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr = {2, 7, 6, 1, 4, 3};
        int[] arr1 = {5, 4, 3, 2, 1};
//        findLeaders(arr);
        System.out.println(Arrays.toString(findLeaders1(arr)));
    }

    static void findLeaders(int[] arr) {
        int largest = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > largest) {
                largest = arr[i];
                System.out.println(largest);
            }
        }
    }

    static int[] findLeaders1(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int[] ans = new int[arr.length];
        int index = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > largest) {
                largest = arr[i];
                ans[index] = largest;
                index++;
            }
        }
        return ans;
    }
}
