package com.company.SortingAlgorithms.Algorithms;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 1, 4, 2, 7};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            sort(arr, low, pivotIndex-1);
            sort(arr, pivotIndex+1, high);
        }
    }

    // For optimization
    static void random(int[] arr, int low, int high) {
        int randomIndex = low + (int) (Math.random() * (high-low+1));
        swap(arr, low, randomIndex);
    }

    static int partition(int[] arr, int low, int high) {
        int i = low;
        int j = high;
//        random(arr, low, high);
        int mid = low + (high - low)/2;
        swap(arr, low, mid); // for optimization
        int pivot = arr[low];
        while (i < j) {
            while (i < j && arr[i] <= pivot) i++;
            while (arr[j] > pivot) j--;
            if (i < j) {
                swap(arr, i, j);
            }
        }
        // Now we've found right index
        swap(arr, low, j);

        return j;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
