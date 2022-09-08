package com.company.HeapPriorityQueue.Part1;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {
    public static void main(String[] args) {
        int[] nums = {4, 3, 1, 2, 6, 5};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
        System.out.println(kthSmallest(nums, 0, nums.length, k));
    }

    static int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (!queue.isEmpty() && queue.peek() < nums[i]) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }

    static int kthSmallest(int[] arr, int l, int r, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (!queue.isEmpty() && queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        return queue.peek();
    }
}
