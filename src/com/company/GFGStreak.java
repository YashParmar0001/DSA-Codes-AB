package com.company;

import java.util.Collections;
import java.util.PriorityQueue;

public class GFGStreak {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 5, 4};
        int n = arr.length;
        System.out.println(minimumNumber(n, arr));
    }

    static int minimumNumber(int n, int[] arr) {
        if (n <= 1) return arr[0];

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int e : arr) {
            queue.offer(e);
        }

        int max = -1, min = -1;
        int ans = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            max = queue.poll();
            min = queue.poll();
            if (min == 0) {
                ans = Math.max(ans, max);
                return ans;
            }
            int num = max - min;
//            if (num == 0) return ans;
//            ans = Math.max(ans, max);
            queue.offer(num); queue.offer(min);
        }
        return ans;
    }
}
