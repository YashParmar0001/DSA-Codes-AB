package com.company.ArrayPracticeProblems.GFGSheet;

import java.util.HashMap;

public class Largest0SumSubarray {
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, -10};
        System.out.println(maxLen(arr, arr.length));
    }

    static int maxLen(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefixSum = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            if (map.containsKey(prefixSum)) {
                ans = Math.max(ans, i-map.get(prefixSum));
            }else {
                map.put(prefixSum, i);
            }
        }
        return ans;
    }
}
