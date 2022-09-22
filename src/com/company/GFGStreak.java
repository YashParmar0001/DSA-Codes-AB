package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class GFGStreak {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        System.out.println(max_of_subarrays(arr, arr.length, 3));
    }

    static ArrayList<Integer> max_of_subarrays(int[] arr, int n, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }

            deque.offer(i);
            if (i >= k-1) {
                ans.add(arr[deque.peek()]);
            }
        }
        return ans;
    }
}
