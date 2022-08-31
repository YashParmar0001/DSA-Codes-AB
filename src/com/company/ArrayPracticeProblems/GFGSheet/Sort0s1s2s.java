package com.company.ArrayPracticeProblems.GFGSheet;

import java.util.Arrays;

public class Sort0s1s2s {
    public static void main(String[] args) {
        int[] arr = {2, 0, 1};
        sort012(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void sort012(int arr[], int n) {
        int low = 0;
        int high = n-1;
        int mid = 0;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, mid, low);
                mid++; low++;
            }else if (arr[mid] == 1) {
                mid++;
            }else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
