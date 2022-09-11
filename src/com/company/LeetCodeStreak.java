package com.company;

import java.util.*;

public class LeetCodeStreak {
    public static void main(String[] args) {
        int[][] intervals = {{5,10},{6,8},{1,5},{2,3},{1,10}};
        System.out.println(minGroups(intervals));
    }

    static int minGroups(int[][] intervals) {
        if (intervals.length < 2) return 1;
        Arrays.sort(intervals);
        int ans = 0;
        boolean[] isValid = new boolean[intervals.length];
        Arrays.fill(isValid, true);
        int i = 0, j = -1;
        while (i < intervals.length-1 && j < intervals.length) {
            if (!isValid[i]) {
                i++;
                continue;
            }
            j = i + 1;
            int[] interval = intervals[i];
            boolean flag = false;
            int count = 0;
            while (j < intervals.length) {
                if (isValid[j] && isValidGroup(interval, intervals[j])) {
                    interval = new int[]{Math.min(interval[0], intervals[j][0]),
                            Math.max(interval[1], intervals[j][1])};
                    isValid[j] = false;
                    count++;
                }
                j++;
            }
            if (count != 0) ans++;
//            count = 0;
        }
        return ans;
    }

    static boolean isValidGroup(int[] a, int[] b) {
        return !(a[0] == b[0] || a[1] == b[0] || a[0] == b[1] || a[1] == b[1]);
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