package com.company.Hashing.Part1;

import java.util.HashMap;
import java.util.Map;

public class FourSum {
    public static void main(String[] args) {

    }

    static class Pair {
        int i, j;
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static void fourSum(int[] arr, int target) {
        Map<Integer, Pair> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                map.put(arr[i] + arr[j], new Pair(i, j));
            }
        }

        for (Map.Entry<Integer, Pair> entry : map.entrySet()) {
            int firstSum = entry.getKey();
            Pair firstPair = entry.getValue();
            int secondSum = target - firstSum;

            if (map.containsKey(secondSum)) {
                Pair secondPair = map.get(secondSum);
                // We need distinct indices so check for it
                if (firstPair.i != secondPair.i && firstPair.i != secondPair.j &&
                            firstPair.j != secondPair.i && firstPair.j != secondPair.j) {
                    System.out.println(firstPair.i + ", " + firstPair.j + ", " + secondPair.i + ", " + secondPair.j);
                    return;
                }
            }
        }

        System.out.println("Not found!");
    }
}
