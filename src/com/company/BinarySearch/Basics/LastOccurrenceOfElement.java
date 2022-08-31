package com.company.BinarySearch.Basics;

public class LastOccurrenceOfElement {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 4, 4, 4, 4, 5, 6, 6};
        System.out.println(findLastOccurrence(arr, 1));
    }

    static int findLastOccurrence(int[] arr, int target) {
        int start = 0, end = arr.length-1;
        int ans = -1;
        int mid;

        while (start <= end) {
            mid = start + (end - start)/2;
            if (arr[mid] == target) {
                ans = mid;
                start = mid + 1;
            }else if (arr[mid] < target) {
                start = mid + 1;
            }else end = mid - 1;
        }

        return ans;
    }
}
