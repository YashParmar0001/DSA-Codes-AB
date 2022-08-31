package com.company.BitWise.Problems;

import java.util.Arrays;

public class FindNonRepeating {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 1, 2, 3, 4};
        System.out.println(findNonRepeating(arr));
        int[] arr1 = {2, 4, 1, 2, 3, 7, 4, 1};
        System.out.println(Arrays.toString(findTwoNonRepeating(arr1)));
    }

    static int findNonRepeating(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        return result;
    }

    static int[] findTwoNonRepeating(int[] arr) {
        int xor = 0;
        for (int element : arr) {
            xor ^= element;
        }

        int temp = xor;
        // Mask for checking array element's category
        int mask = xor & (~(xor - 1));
//        int mask = xor & (-xor);

        // If element is of same category then xor it
        for (int element : arr) {
            if ((element & mask) == 0) {
                temp ^= element;
            }
        }

        // The end result will be out first number
        int firstNumber = temp;
        int secondNumber = temp ^ xor;

        return new int[]{firstNumber, secondNumber};
    }
}
