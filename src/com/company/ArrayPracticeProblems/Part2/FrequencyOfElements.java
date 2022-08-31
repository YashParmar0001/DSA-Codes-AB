package com.company.ArrayPracticeProblems.Part2;

public class FrequencyOfElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 3, 4, 4, 4, 4};
        printFrequency(arr);
    }

    static void printFrequency(int[] arr) {
        int current = arr[0];
        int count = 0;
        for (int j : arr) {
            if (current == j) {
                count++;
            } else {
                System.out.print(count + ", ");
                count = 1;
                current = j;
            }
        }
        // for last one
        System.out.print(count);
    }
}
