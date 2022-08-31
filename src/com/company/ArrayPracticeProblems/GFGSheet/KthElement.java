package com.company.ArrayPracticeProblems.GFGSheet;

public class KthElement {
    public static void main(String[] args) {
        int[] arr1 = {100, 112, 256, 349, 770};
        int[] arr2 = {72, 86, 113, 119, 265, 445, 892};
        System.out.println(kthElement2(arr1, arr2, arr1.length, arr2.length, 7));
    }

    static long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        int i = 0, j = 0;
        int index = 0;
        int[] ans = new int[arr1.length + arr2.length];
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                ans[index] = arr1[i];
                i++;
            }else {
                ans[index] = arr2[j];
                j++;
            }
            index++;
        }
        if (i == arr1.length) {
            while (j < arr2.length) {
                ans[index] = arr2[j];
                j++;
                index++;
            }
        }else if (j == arr2.length) {
            while (i < arr1.length) {
                ans[index] = arr1[i];
                i++;
                index++;
            }
        }
        return ans[k-1];
    }

    // Time : O(k), Space : O(1)
    static long kthElement1(int[] arr1, int[] arr2, int n, int m, int k) {
        int i = 0, j = 0;
        int index = 0;
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                index++;
                if (index == k) return arr1[i];
                i++;
            }else if (arr1[i] > arr2[j]) {
                index++;
                if (index == k) return arr2[j];
                j++;
            }
        }

        while (i < n) {
            index++;
            if (index == k) return arr1[i];
            i++;
        }

        while (j < m) {
            index++;
            if (index == k) return arr2[j];
            j++;
        }

        return -1;
    }

    // Binary search, Time : O(logn + logm), Space : O(1)
    static long kthElement2(int[] arr1, int[] arr2, int n, int m, int k) {
        int start1 = 0, end1 = n-1;
        int start2 = 0, end2 = m-1;
        if (start1 == end1) return arr2[k];
        if (start2 == end2) return arr1[k];

        int mid1;
        int mid2;

        while (true) {
            if (start1 == end1) return arr2[k-1];
            if (start2 == end2) return arr1[k-1];
            mid1 = start1 + (end1 - start1)/2;
            mid2 = start2 + (end2 - start2)/2;

            if (mid1 + mid2 >= k) {
                if (arr1[mid1] > arr2[mid2]) {
                    end1 = mid1;
                }else {
                    end2 = mid2;
                }
            }else {
                if (arr1[mid1] > arr2[mid2]) {
                    start2 = mid2 + 1;
                    k = k - mid2 - 1;
                }else {
                    start1 = mid1 + 1;
                    k = k - mid1 - 1;
                }
            }
        }
    }
}
