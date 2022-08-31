package com.company.BinarySearch.Part1;

public class SearchInInfiniteSortedArray {
    public static void main(String[] args) {
        // Array is infinite (Assume)
        // Element should be present on n/2 (Theoretical)
        int[] arr = {1, 2, 3, 4, 6, 7, 8, 11, 13, 15, 23, 24, 31, 32, 34, 36, 40, 45, 48, 50};
        System.out.println(searchInfinite(arr, 5));
    }

    static int searchInfinite(int[] arr, int target) {
        if (arr.length == 0) return -1;
        if (arr[0] == target) return 0;

        int index = 1;

        while (arr[index] <= target) {
            index *= 2;
        }

        return binarySearch(arr, target, index/2, index);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
