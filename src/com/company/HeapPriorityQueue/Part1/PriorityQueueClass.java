package com.company.HeapPriorityQueue.Part1;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueClass {
    public static void main(String[] args) {
        Queue<Integer> minQueue = new PriorityQueue<>();
        minQueue.offer(5);
        minQueue.offer(10);
        minQueue.offer(9);
        minQueue.offer(1);
        while (!minQueue.isEmpty()) {
            System.out.print(minQueue.poll() + ", ");
        }
        System.out.println();
//        Queue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        // Using Comparator
//        Queue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
        // Using Lambda function
        Queue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2-o1);
        maxQueue.offer(5);
        maxQueue.offer(10);
        maxQueue.offer(9);
        maxQueue.offer(1);
        while (!maxQueue.isEmpty()) {
            System.out.print(maxQueue.poll() + ", ");
        }

        Queue<Student> queue = new PriorityQueue<>((o1, o2) -> o2.rollNo-o1.rollNo);
    }

    static class Student {
        int rollNo;
        String name;
    }
}
