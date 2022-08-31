package com.company.StackClass.Part2;

import java.util.ArrayDeque;

// https://practice.geeksforgeeks.org/problems/get-minimum-element-from-stack/1
public class MinstackImplementation {
    public static void main(String[] args) throws Exception {
        MinStack1 stack = new MinStack1();
        stack.push(10);
        stack.push(11);
        stack.push(9);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
    }
}

// O(n) extra space
class MinStack {
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    ArrayDeque<Integer> minStack = new ArrayDeque<>();

    void push(int element) {
        stack.push(element);
        if (minStack.isEmpty()) {
            minStack.push(element);
            return;
        }
        if (element <= minStack.peek()) {
            minStack.push(element);
        }
    }

    int top() {
        return stack.peek();
    }

    int pop() throws Exception {
        if (stack.isEmpty()) throw new Exception("Stack is Empty!");
        int ans = stack.pop();
        if (ans == minStack.peek()) {
            minStack.pop();
        }
        return ans;
    }

    int min() throws Exception {
        if (stack.isEmpty()) throw new Exception("Stack is Empty!");
        return minStack.peek();
    }
}

// O(1) Space
// https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
class MinStack1 {
    ArrayDeque<Integer> stack;
    int min;

    public MinStack1() {
        stack = new ArrayDeque<>();
        min = Integer.MAX_VALUE;
    }

    void push(int element) {
        if (stack.isEmpty()) {
            min = element;
            stack.push(element);
            return;
        }
        if (element >= min) {
            stack.push(element);
        }else {
            stack.push(2 * element - min);
            min = element;
        }
    }

    int pop() {
        int data = stack.pop();
        if (data >= min) {
            return data;
        }else {
            int ans = min;
            min = 2 * min - data;
            return ans;
        }
    }

    int getMin() throws Exception {
        if (stack.isEmpty()) throw new Exception("Stack is Empty!");
        return min;
    }

    int top() {
        int data = stack.peek();
        return Math.max(data, min);
    }
}
