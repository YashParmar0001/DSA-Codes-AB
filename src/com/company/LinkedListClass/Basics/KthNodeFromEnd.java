package com.company.LinkedListClass.Basics;

public class KthNodeFromEnd {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;

        System.out.println(getNthFromLast1(n1, 2));
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static int findLength(Node head) {
        if (head == null) return 0;
        int length = 0;
        Node current = head;
        while (current != null) {
            current = current.next;
            length++;
        }
        return length;
    }

    static int getNthFromLast(Node head, int n) {
        int length = findLength(head);
        if (length < n) return -1;
        Node current = head;
        for (int i = 0; i < length-n; i++) {
            current = current.next;
        }
        return current.data;
    }

    // In single traversal
    static int getNthFromLast1(Node head, int n) {
        if (head == null) return -1;
        Node mainPointer = head;
        Node refPointer = head;
        int count = 0;
        while (count < n) {
            if (refPointer == null) {
                return -1;
            }
            refPointer = refPointer.next;
            count++;
        }

        if (refPointer == null) {
            if (mainPointer != null) return head.data;
        }else {
            while (refPointer != null) {
                mainPointer = mainPointer.next;
                refPointer = refPointer.next;
            }
            return mainPointer.data;
        }
        return -1;
    }
}
