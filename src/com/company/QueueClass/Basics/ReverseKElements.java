package com.company.QueueClass.Basics;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseKElements {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
//        System.out.println(modifyQueue(queue, 5));
        System.out.println(modifyQueue1(queue, 3));
    }

    static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Queue<Integer> queue = new LinkedList<>();
        while (!q.isEmpty() && k > 0) {
            stack.push(q.poll());
            k--;
        }
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
        while (!q.isEmpty()) {
            queue.offer(q.poll());
        }
        return queue;
    }

    static Queue<Integer> modifyQueue1(Queue<Integer> q, int k) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = q.size();

        for (int i = 0;!q.isEmpty() && i < k; i++) {
            stack.push(q.poll());
        }

        while (!stack.isEmpty()) q.offer(stack.pop());

        for (int i = 0; i < n - k; i++) {
            q.offer(q.poll());
        }

        return q;
    }
}
