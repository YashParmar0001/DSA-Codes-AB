package com.company.HeapPriorityQueue.Part2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class SplitArray {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 3, 7, 2, 4, 5, 6, 3};
        int k = 3;
        System.out.println(splitArray(arr, k));
    }

    static int splitArray(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            queue.offer(0);
        }
        Arrays.sort(arr);
        for (int i = arr.length-1; i >= 0; i--) {
            int current = arr[i];
            int top = queue.poll();
            int toAdd = current + top;
            queue.offer(toAdd);
        }
        int max = 0;

        while (queue.size() > 0) {
            max = queue.poll();
        }

        return max;
    }
}
