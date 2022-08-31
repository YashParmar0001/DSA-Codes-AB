package com.company.ArrayPracticeProblems.GFGSheet;

import java.util.Arrays;

public class RearrangeArray {
    public static void main(String[] args) {
        long[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        rearrange1(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void rearrange(long[] arr, int n){
        int i = 0, j = n - 1;
        int index = 0;
        long[] ans = new long[arr.length];
        while (i < j) {
            ans[index++] = arr[j];
            ans[index++] = arr[i];
            i++;
            j--;
        }
        if ((ans.length & 1) == 1) ans[index] = arr[i];
        for (int k = 0; k < arr.length; k++) {
            arr[k] = ans[k];
        }
    }

    // https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately-1587115620/1
    static void rearrange1(long[] arr, int n) {
        int max_idx = n - 1, min_idx = 0;
        long max_element = arr[n-1] + 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] += (arr[max_idx] % max_element) * max_element;
                max_idx--;
            }else {
                arr[i] += (arr[min_idx] % max_element) * max_element;
                min_idx++;
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] /= max_element;
        }
    }
}
