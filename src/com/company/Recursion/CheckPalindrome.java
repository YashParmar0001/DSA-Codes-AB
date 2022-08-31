package com.company.Recursion;

public class CheckPalindrome {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1};
        System.out.println(check1(arr, 0, arr.length - 1));
    }

    static boolean check(int[] arr) {
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            if (arr[i] != arr[j]) return false;

            i++; j--;
        }
        return true;
    }

    static boolean check1(int[] arr, int i, int j) {
        if (arr[i] != arr[j]) return false;

        if (i > j) return true;

        return check1(arr, i + 1, j - 1);
    }
}
