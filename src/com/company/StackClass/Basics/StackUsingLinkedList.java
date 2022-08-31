package com.company.StackClass.Basics;

import java.util.ArrayDeque;

public class StackUsingLinkedList {
    public static void main(String[] args) throws Exception {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
//        StackLinkedList stack = new StackLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
//        System.out.println(stack.pop()); --> Throws exception
    }
}

class StackLinkedList {
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }
    Node head;
    int size;

    void push(int element) {
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        size++;
    }

    int pop() throws Exception{
        if (isEmpty()) throw new Exception("Stack is Empty!");
        int ans = head.data;
        head = head.next;
        size--;
        return ans;
    }

    int peek() throws Exception {
        if (isEmpty()) throw new Exception("Stack is empty!");
        return head.data;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }
}
