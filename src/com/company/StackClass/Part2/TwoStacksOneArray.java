package com.company.StackClass.Part2;

public class TwoStacksOneArray {
    public static void main(String[] args) throws Exception {
        TwoStacks stack = new TwoStacks(5);
        stack.push1(1);
        stack.push1(2);
        stack.push1(3);
        stack.push2(4);
        stack.push2(5);
        System.out.println(stack.pop1());
        System.out.println(stack.pop1());
        System.out.println(stack.pop1());
        System.out.println(stack.pop2());
        System.out.println(stack.pop2());
    }
}

class TwoStacks {
    int[] arr;
    int top1, top2;

    public TwoStacks(int capacity) {
        arr = new int[capacity];
        top1 = -1;
        top2 = capacity;
    }

    void push1(int data) {
        if (top1 + 1 < top2) {
            top1++;
            arr[top1] = data;
        }else {
            throw new StackOverflowError();
        }
    }

    void push2(int data) {
        if (top1 + 1 < top2) {
            top2--;
            arr[top2] = data;
        }else {
            throw new StackOverflowError();
        }
    }

    int pop1() throws Exception {
        if (top1 != -1) {
            int data = arr[top1];
            top1--;
            return data;
        }else {
            throw new Exception("Stack is Empty!");
        }
    }

    int pop2() throws Exception {
        if (top2 != arr.length) {
            int data = arr[top2];
            top2++;
            return data;
        }else throw new Exception("Stack is Empty!");
    }
}
