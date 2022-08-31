package com.company.Hashing.Basics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 5, 4, 6, 9, 7, 5, 12};
        System.out.println(Arrays.toString(twoSum(arr, 50)));
    }

    static int[] twoSum(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();
        for (int element : arr) {
            int comp = target - element;
            if (set.contains(comp)) return new int[]{comp, element};
            else set.add(element);
        }
        return new int[]{-1, -1};
    }
}
