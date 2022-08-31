package com.company.StackClass.Basics;

public class StackUsingArray {
    public static void main(String[] args) throws Exception {
        StackArray stack = new StackArray(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
//        stack.push(1); --> Throws exception
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
//        System.out.println(stack.pop()); --> Throws exception
    }
}

class StackArray {
    int[] arr;
    int top;
    int capacity;
    public StackArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        top = -1;
    }

    boolean push(int element) throws Exception {
        if (top == capacity-1) throw new Exception("Stack is full!");
        top++;
        arr[top] = element;
        return true;
    }

    int pop() throws Exception {
        if (top == -1) throw new Exception("Stack is empty!");
        int element = arr[top];
        top--;
        return element;
    }

    // Return top element from stack without deleting it
    int peek() throws Exception {
        if (top == -1) throw new Exception("Stack is empty!");
        return arr[top];
    }

    boolean isEmpty() {
        return top == -1;
    }

    int size() {
        return top + 1;
    }
}
