package com.company.BinarySearch.Basics;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 9, 10};
        System.out.println(search(arr, 5));
        System.out.println(searchRecursive(arr, 0, arr.length-1, 5));
    }

    static int search(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start)/2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    // Time : O(logn), Space : O(logn)
    static int searchRecursive(int[] arr, int low, int high, int target) {
        if (low > high) return -1;

        int mid = low + (high - low)/2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) {
            return searchRecursive(arr, mid + 1, high, target);
        }else {
            return searchRecursive(arr, low, mid - 1, target);
        }
    }
}
