package com.company;

import java.util.*;

public class LeetCodeStreak {
    public static void main(String[] args) {
        int[] arr = {0,0,1,2,3,3,4,7,7,8};
        int k = 3;
        int x = 5;
        System.out.println(findClosestElements(arr, k, x));
    }

    static List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a - x) < Math.abs(b-x)) {
                return -1;
            }else if (Math.abs(a-x) > Math.abs(b-x)) {
                return 1;
            }else return a.compareTo(b);
        });
        for (int e : arr) {
            queue.offer(e);
        }
        int index = 0;
        List<Integer> list = new ArrayList<>(k);
        while (!queue.isEmpty() && index < k) {
            list.add(queue.poll());
            index++;
        }
        Collections.sort(list);
        return list;
    }
}