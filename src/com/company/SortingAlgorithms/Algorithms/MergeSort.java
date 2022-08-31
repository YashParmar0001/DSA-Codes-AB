package com.company.SortingAlgorithms.Algorithms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {9, 7, 6, 4, 2, 1, 4};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            sort(arr, low, mid);
            sort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
    }

    static void merge(int[] arr, int low, int mid, int high) {
        int[] ans = new int[arr.length];
        int i = low;
        int j = mid + 1;
        int index = low;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                ans[index] = arr[i];
                i++;
            }else {
                ans[index] = arr[j];
                j++;
            }
            index++;
        }

        // There might be a case where one of the array is remained incomplete
        if (i > mid) {
            while (j <= high) {
                ans[index] = arr[j];
                index++; j++;
            }
        }else {
            while (i <= mid) {
                ans[index] = arr[i];
                index++; i++;
            }
        }

        for (i = low; i <= high; i++) {
            arr[i] = ans[i];
        }
    }
}
