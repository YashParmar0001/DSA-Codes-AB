package com.company;

import java.util.HashMap;
import java.util.Map;

public class LeetCodeStreak {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, -4};
        System.out.println(mostFrequentEven(nums));
    }

    static int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                if (num % 2 == 0) map.put(num, 1);
            }else {
                int x = map.get(num);
                map.put(num, x+1);
            }
        }
        int ans = -1;
        int prevKey = -1;
        int prevValue = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (prevValue == value) {
                if (prevKey > key) {
                    ans = key;
                    prevKey = key;
                }
            }else if (prevValue < value) {
                prevKey = key;
                prevValue = value;
                ans = key;
            }
        }
        return ans;
    }
}
