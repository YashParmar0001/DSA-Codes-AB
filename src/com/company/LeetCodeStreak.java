package com.company;

import java.util.*;

public class LeetCodeStreak {
    public static void main(String[] args) {
        String s = "s";
        System.out.println(partitionString(s));
    }

    static int partitionString(String s) {
        if (s.length() < 2) return 1;
        Set<Character> set = new HashSet<>();
        int i = 0, j = 1;
        char[] str = s.toCharArray();
        set.add(str[i]);
        int ans = 0;
        while (j < s.length()) {
            if (!set.contains(str[j])) {
                set.add(str[j]);
                j++;
            } else {
                ans++;
                i = j;
                j = i + 1;
                set = new HashSet<>();
                set.add(str[i]);
            }
        }
        return ans + 1;
    }

    static int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                if (num % 2 == 0) map.put(num, 1);
            } else {
                int x = map.get(num);
                map.put(num, x + 1);
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
            } else if (prevValue < value) {
                prevKey = key;
                prevValue = value;
                ans = key;
            }
        }
        return ans + 1;
    }
}