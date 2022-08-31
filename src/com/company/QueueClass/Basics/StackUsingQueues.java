package com.company.QueueClass.Basics;

import java.util.ArrayDeque;

public class StackUsingQueues {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

class MyStack {

    ArrayDeque<Integer> input;
    ArrayDeque<Integer> output;

    public MyStack() {
        input = new ArrayDeque<>();
        output = new ArrayDeque<>();
    }

    public void push(int x) {
        input.offer(x);
    }

    public int pop() {
        reverse();
        int ans = input.poll();
        reverse();
        return ans;
    }

    public int top() {
        reverse();
        int ans = input.peek();
        reverse();
        return ans;
    }

    public boolean empty() {
        return input.isEmpty();
    }

    public void reverse() {
        if (input.isEmpty()) return;
        int element = input.poll();
        reverse();
        input.offer(element);
    }
}
