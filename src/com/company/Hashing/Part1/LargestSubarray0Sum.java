package com.company.Hashing.Part1;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarray0Sum {
    public static void main(String[] args) {
        int[] arr = {1, 1, 5, -3, -4, 3, 4, 1};
        System.out.println(largest(arr));
    }

    static int largest(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int cumulativeSum = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            cumulativeSum += element;
            if (map.containsKey(cumulativeSum)) {
                int prev = map.get(cumulativeSum);
                ans = Math.max(ans, i-prev);
            }else {
                map.put(cumulativeSum, i);
            }
        }
        return ans;
    }
}
