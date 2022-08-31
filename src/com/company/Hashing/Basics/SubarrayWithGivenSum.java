package com.company.Hashing.Basics;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 2, 7, 9, 8};
        int sum = 10;
        System.out.println(isPresent(arr, sum));
    }

    static boolean isPresent(int[] arr, int sum) {
        int currSum = 0;
        for (int num : arr) {
            currSum += num;
            if (currSum == sum) return true;
            else if (currSum > sum) {
                currSum = num;
            }
        }
        return false;
    }
}
