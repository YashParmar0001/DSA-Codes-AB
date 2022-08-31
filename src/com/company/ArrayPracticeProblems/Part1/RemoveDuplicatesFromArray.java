package com.company.ArrayPracticeProblems.Part1;

import java.util.Arrays;

public class RemoveDuplicatesFromArray {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        removeDuplicate(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void removeDuplicate(int[] arr) {
        int i = 1, j = 0;
        while (i < arr.length) {
            if (arr[i] != arr[j]) {
                arr[j+1] = arr[i];
                j++;
            }else i++;
        }
    }
}
