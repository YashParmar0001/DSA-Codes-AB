package com.company.ArrayPracticeProblems.GFGSheet;

import java.util.*;

import static java.util.Collections.swap;

public class ReverseInGroups {
    public static void main(String[] args) {
        Integer[] nums = {1, 2};
        ArrayList<Integer> arr = new ArrayList<>();
        Collections.addAll(arr, nums);
        reverseInGroups(arr, arr.size(), 2);
//        reverse(arr, 0, 2);
        System.out.println(arr);
    }

    static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        int i = 0, j = 0;
        while (i < arr.size()) {
            while (j < arr.size()-1 && j < i + k - 1) j++;
            reverse(arr, i, j);
            i = j + 1;
            j = i;
        }
    }

    static void reverse(ArrayList<Integer> arr, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            swap(arr, i, j);
            i++; j--;
        }
    }
}
