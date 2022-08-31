package com.company.BinarySearch.Basics;

public class SearchInRotatedArray {
    public static void main(String[] args) {
//        int[] arr = {4, 5, 7, 8, 9, 1, 2, 3};
        int[] arr = {8, 2};
        System.out.println(searchOptimized(arr, 8));
    }

    // Better approach
    static int searchOptimized(int[] arr, int target) {
        int left = 0, right = arr.length-1;
        int mid;

        while (left <= right) {
            mid = left + (right-left)/2;
            if (arr[mid] == target) return mid;
            else if (arr[left] <= arr[mid]) { // left part is sorted
                if (target >= arr[left] && target < arr[mid]) { // left side present
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else { // right part is sorted
                if (target > arr[mid] && target <= arr[right]) { // right side present
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    // Pivot approach
    static int search(int[] arr, int target) {
        int pivot = findPivot(arr);
        int left = binarySearch(arr, target, 0, pivot);
        int right = binarySearch(arr, target, pivot+1, arr.length-1);
        if (left != -1) return left;
        else return right;
    }

    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while (start <= end) {
            mid = start + (end - start)/2;
            if (mid < arr.length-1 && arr[mid] > arr[mid+1]) {
                return mid;
            }else if (arr[mid] > arr[end]) {
                start = mid + 1;
            }else end = mid - 1;
        }
        return -1;
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
