package com.company.LinkedListClass.Basics;

public class RemoveDuplicates {

    static class Node {
        int data;
        Node next;

        public Node() {}
        public Node(int data) {
            this.data = data;
        }
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(2);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(6);
        Node n8 = new Node(7);
//        Node n9 = new Node(9);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
//        n8.next = n9;

        Node head = deleteDuplicates(n1);
        printLL(head);
    }

    static void printLL(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println(" NULL");
    }

    static Node deleteDuplicates(Node head) {
        if (head == null || head.next == null) return head;
        Node current = head;
        int value;
        int nextValue;
        while (current != null) {
            if (current.next == null) break;
            value = current.data;
            nextValue = current.next.data;
            if (value == nextValue) {
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
        return head;
    }
}
