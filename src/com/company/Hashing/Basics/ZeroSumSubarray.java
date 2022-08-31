package com.company.Hashing.Basics;

import java.util.HashSet;
import java.util.Set;

public class ZeroSumSubarray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 2, -3, -2, 3};
        System.out.println(isZeroSum(arr));
    }

    static boolean isZeroSum(int[] arr) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int prefixSum = 0;
        for (int num : arr) {
            prefixSum += num;
            if (set.contains(prefixSum)) return true;
            else set.add(prefixSum);
        }
        return false;
    }
}
