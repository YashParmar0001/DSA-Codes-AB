package com.company.Hashing.Basics;

import java.util.HashMap;
import java.util.Map;

public class FrequencyOfElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 4, 3, 4, 2};
        System.out.println(frequency(arr));
    }

    static String frequency(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int element : arr) {
            if (!map.containsKey(element)) {
                map.put(element, 1);
            }else {
                int temp = map.get(element);
                map.put(element, temp+1);
            }
        }
        return map.toString();
    }
}
