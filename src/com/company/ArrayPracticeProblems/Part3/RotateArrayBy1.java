package com.company.ArrayPracticeProblems.Part3;

import java.util.Arrays;

public class RotateArrayBy1 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        rotate(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void rotate(int[] arr) {
//        int pivot = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            swap(arr, i, i + 1);
        }
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
