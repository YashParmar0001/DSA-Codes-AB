package com.company.StackClass.Basics;

import java.util.Stack;

public class DeleteMiddle {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
//        stack.push(5);
        deleteMid(stack, stack.size());
        System.out.println(stack);
    }

    static void deleteMid(Stack<Integer> s, int sizeOfStack){
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        int mid = (sizeOfStack+1)/2;
        while (!s.isEmpty()) {
            if (count == sizeOfStack - mid) {
                s.pop();
                count++;
                continue;
            }
            stack.push(s.pop());
            count++;
        }
        while (!stack.isEmpty()) {
            s.push(stack.pop());
        }
    }
}
