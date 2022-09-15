package com.company;

import java.util.*;

public class LeetCodeStreak {
    public static void main(String[] args) {
        int[] changed = {4,4,16,20,8,8,2,10};
        System.out.println(Arrays.toString(findOriginalArray(changed)));
    }

    static int[] findOriginalArray(int[] changed) {
        if (changed.length%2 == 1) return new int[]{};
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : changed) {
            if (!map.containsKey(e)) {
                map.put(e, 1);
            }else {
                int freq = map.get(e);
                map.put(e, freq+1);
            }
        }
        int[] ans = new int[changed.length/2]; int index = 0;
        Arrays.sort(changed);
        for (int e : changed) {
            if (map.containsKey(e)) {
                int freq1 = map.get(e);
                if (map.containsKey(e*2)) {
                    if (e == e*2) {
                        if (freq1-2 == 0) map.remove(e*2);
                        else map.put(e, freq1-2);
                        continue;
                    }
                    int freq2 = map.get(e*2);
                    ans[index] = e; index++;
                    if (freq1-1 == 0) map.remove(e);
                    else map.put(e, freq1-1);
                    if (freq2-1 == 0) map.remove(e*2);
                    else map.put(e*2, freq2-1);
                }
            }
            if (index == ans.length) break;
        }
        if (!map.isEmpty()) return new int[]{};
        return ans;
    }
}