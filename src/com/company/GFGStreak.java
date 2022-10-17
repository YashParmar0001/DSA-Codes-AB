package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class GFGStreak {
    public static void main(String[] args) {
        int[] arr = {8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28};
        System.out.println(findLeastGreater(arr.length, arr));
    }

    public static ArrayList<Integer> findLeastGreater(int n, int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        int[] ansArr = new int[n];
        for (int i = n-1; i >= 0; i--) {
            if (set.ceiling(arr[i]+1) == null) {
                ansArr[i] = -1;
            }else {
                ansArr[i] = set.ceiling(arr[i]+1); // This works like an upper bound
            }
            set.add(arr[i]);
        }
        for (int e : ansArr) ans.add(e);
        return ans;
    }
}
