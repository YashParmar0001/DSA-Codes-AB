package com.company.ArrayPracticeProblems.GFGSheet;

import java.util.Arrays;

public class ZigZagOrderArray {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2};
        zigZag(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void zigZag(int[] arr, int n) {
        for (int i = 0; i < n-1; i++) {
            if (i % 2 == 0) {
                if (arr[i] > arr[i+1]) swap(arr, i, i+1);
            }else {
                if (arr[i] < arr[i+1]) swap(arr, i, i+1);
            }
        }
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
