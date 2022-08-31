package com.company.Hashing.GFGSheet;

import java.util.HashMap;
import java.util.Map;

public class ElementKTimes {
    public static void main(String[] args) {
        int[] a = {3, 1, 2};
        System.out.println(firstElementKTime(a, a.length, 1));
    }

    static int firstElementKTime(int[] a, int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int temp;
        for (int num : a) {
            if (map.containsKey(num)) {
                temp = map.get(num);
                map.put(num, temp+1);
            }else {
                map.put(num, 1);
            }
            if (map.get(num) == k) return num;
        }
        return -1;
    }
}
