package com.company.SortingAlgorithms.Algorithms;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 6, 3, 1, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr) {
        // Assuming 1st element of array is sorted
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            // Element from unsorted part
            int temp = arr[i];
            for (; j >= 0; j--) {
                if (temp < arr[j]) {
                    arr[j+1] = arr[j];
                }else break;
            }
            arr[j+1] = temp;
        }
    }
}
