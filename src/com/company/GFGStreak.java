package com.company;

import java.util.HashMap;
import java.util.Map;

public class GFGStreak {
    public static void main(String[] args) {
        String s = "rdsaugup"; int k = 5;
        System.out.println(countOfSubstrings(s, k));

    }

    static int countOfSubstrings(String s, int k) {
        char[] str = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int ans = 0;
        while (j < s.length()) {
            if (!map.containsKey(str[j])) {
                map.put(str[j], 0);
            }
            map.put(str[j], map.get(str[j]) + 1);
            j++;
            if (j - i == k) {
                if (map.size() == k-1) ans++;
                map.put(str[i], map.get(str[i]) - 1);
                if (map.get(str[i]) <= 0) map.remove(str[i]);
                i++;
            }
        }
        return ans;
    }
}
