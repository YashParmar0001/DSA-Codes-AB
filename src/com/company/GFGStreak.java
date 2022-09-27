package com.company;

import java.util.PriorityQueue;

public class GFGStreak {
    public static void main(String[] args) {

    }

    long minCost(long arr[], int n) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (long e : arr) {
            queue.offer(e);
        }
        long cost = 0;
        while (queue.size() > 1) {
            long first = queue.poll();
            long second = queue.poll();
            cost += first + second;
            queue.offer(first + second);
        }
        return cost;
    }
}
