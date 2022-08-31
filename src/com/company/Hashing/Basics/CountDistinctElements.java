package com.company.Hashing.Basics;

import java.util.HashSet;
import java.util.Set;

public class CountDistinctElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1, 4, 4, 5};
        System.out.println(count(arr));
    }

    static int count(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int element : arr) {
            set.add(element);
        }
        return set.size();
    }
}
