package com.company.ArrayPracticeProblems.GFGSheet;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 3};
        System.out.println(missingNumber(arr, arr.length+1));
    }

    static int missingNumber(int[] array, int n) {
        int i = 0;
        while (i < n-1) {
            int correct = array[i] - 1;
            if (array[i] < n && array[i] != array[correct]) {
                swap(array, i, correct);
            }else i++;
        }

        for (int index = 0; index < n-1; index++) {
            if (array[index] != index + 1) return index + 1;
        }
        return n;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
