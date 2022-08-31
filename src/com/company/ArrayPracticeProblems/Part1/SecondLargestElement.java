package com.company.ArrayPracticeProblems.Part1;

public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {6, 5};
        System.out.println(secondLargest1(arr));
    }

    static int secondLargest(int[] arr) {

        if (arr.length < 2) return -1;

        int max = 0;
        int max2 = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[max] < arr[i]) {
                max2 = max;
                max = i;
            }else if (max2 == i || arr[max] > arr[i]) {
                if (arr[i] > arr[max2]) {
                    max2 = i;
                }
            }
        }

        return max2;
    }

    static int secondLargest1(int[] arr) {

        if (arr.length < 2) return -1;

        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > max) {
                max2 = max;
                max = num;
            }else {
                if (max2 < num) {
                    max2 = num;
                }
            }
        }

        return max2;

    }
}
