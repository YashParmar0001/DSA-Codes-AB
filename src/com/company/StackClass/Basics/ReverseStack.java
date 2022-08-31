package com.company.StackClass.Basics;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1); s.push(2); s.push(3); s.push(4);
//        reverse(s);
        reverse1(s);
        System.out.println("Reversed....");
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }

    static void reverse(Stack<Integer> s) {
        int[] arr = new int[s.size()];
        int index = 0;
        while (!s.isEmpty()) {
            arr[index++] = s.pop();
        }
        for (int element : arr) {
            s.push(element);
        }
    }

    static void reverse1(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int x = s.pop();
            reverse1(s);
            insertAtBottom(s, x);
        }
    }

    static void insertAtBottom(Stack<Integer> s, int e) {
        if (s.isEmpty()) {
            s.push(e);
        }else {
            int x = s.pop();
            insertAtBottom(s, e);
            s.push(x);
        }
    }
}
