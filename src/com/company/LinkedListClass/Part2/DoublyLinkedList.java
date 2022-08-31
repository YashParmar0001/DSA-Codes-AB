package com.company.LinkedListClass.Part2;

public class DoublyLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2); head.next.previous = head;
        head.next.next = new Node(3); head.next.next.previous = head.next;
        head.next.next.next = new Node(4); head.next.next.next.previous = head.next.next;
        printForward(head);
        printReverse(head.next.next.next);
    }

    static class Node {
        int data;
        Node next;
        Node previous;
        public Node(int data) {
            this.data = data;
        }
    }

    static void printForward(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println(" NULL");
    }

    static void printReverse(Node tail) {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.previous;
        }
        System.out.println(" NULL");
    }
}
