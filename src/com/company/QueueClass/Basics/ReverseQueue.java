package com.company.QueueClass.Basics;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println(rev(queue));
    }

    static Queue<Integer> rev(Queue<Integer> q){
        reverse(q);
        return q;
    }

    static void reverse(Queue<Integer> q) {
        if (q.isEmpty()) return;
        int element = q.poll();
        reverse(q);
        q.offer(element);
    }
}
