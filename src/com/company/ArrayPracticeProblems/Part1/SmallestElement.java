package com.company.ArrayPracticeProblems.Part1;

public class SmallestElement {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 2, 8};
        System.out.println(minimum(arr));
    }

    static int minimum(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int element : arr) {
            min = Math.min(min, element);
        }
        return min;
    }
}
