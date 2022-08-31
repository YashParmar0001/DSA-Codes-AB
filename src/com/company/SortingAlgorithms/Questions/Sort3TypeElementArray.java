package com.company.SortingAlgorithms.Questions;

import java.util.Arrays;

public class Sort3TypeElementArray {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 0, 0, 1, 2, 0, 1};
//        sort(arr);
        sortDutch(arr);
        System.out.println(Arrays.toString(arr));
    }

    // Dutch flag algorithm
    // Time : O(n)
    static void sortDutch(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid < high) {
            if (arr[mid] == 0) {
                swap(arr, mid, low);
                low++;
                mid++;
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

    static void sort(int[] arr) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int element : arr) {
            if (element == 0) count0++;
            else if (element == 1) count1++;
            else count2++;
        }

        int index = 0;
        for (int i = 1; i <= count0; i++) {
            arr[index] = 0;
            index++;
        }

        for (int i = 1; i <= count1; i++) {
            arr[index] = 1;
            index++;
        }

        for (int i = 1; i <= count2; i++) {
            arr[index] = 2;
            index++;
        }
    }
}
