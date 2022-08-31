package com.company.ArrayPracticeProblems.Part3;

public class ArrayPartition3 {
    public static void main(String[] args) {
        int[] arr = {18,12,-18,18,-19,-1,10,10};
        System.out.println(canThreePartsEqualSum(arr));
    }

    static boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        if (sum % 3 != 0) return false;

        int avg = sum / 3;
        int count = 0;
        int part = 0;

        for (int num : arr) {
            part += num;
            if (part == avg) {
                ++count;
                part = 0;
            }
        }

        return (count >= 3);
    }
}
