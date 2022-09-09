package com.company.HeapPriorityQueue.Part2;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinCostOfRopes {
    public static void main(String[] args) {
        long[] arr = {4, 3, 2, 6};
        int n = arr.length;
        System.out.println(minCost(arr, n));
    }

    static long minCost(long[] arr, int n) {
        Queue<Long> queue = new PriorityQueue<>();
        for (long e : arr) queue.offer(e);

        long ans = 0;
        while (queue.size() > 1) {
            long first = queue.poll();
            long second = queue.poll();
            long cost = first + second;
            ans += cost;
            queue.offer(cost);
        }

        return ans;
    }
}
