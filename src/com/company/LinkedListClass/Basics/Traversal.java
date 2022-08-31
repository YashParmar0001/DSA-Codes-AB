package com.company.LinkedListClass.Basics;

public class Traversal {
    public static void main(String[] args) {
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n5 = new Node<>(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        printLL(n1);
        // n1 is head of linked list
//        n1 = insertLL(23, 0, n1);
        n1 = deleteLL(0, n1);
        printLL(n1);
        System.out.println(findMiddle(n1));
    }

    static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }

    // Traversal
    static void printLL(Node<Integer> head) {
        Node<Integer> current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println(" NULL");
    }

    static Node<Integer> insertLL(int data, int index, Node<Integer> head) {
        Node<Integer> newNode = new Node<>(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return head;
        }

        Node<Integer> current = head;
        for (int i = 0; i < index-1; i++) {
            current = current.next;
            if (current == null) return head;
        }
        newNode.next = current.next;
        current.next = newNode;

        return head;
    }

    static Node<Integer> deleteLL(int index, Node<Integer> head) {
        if (head == null) return null;
        if (index == 0) {
            head = head.next;
            return head;
        }

        Node<Integer> current = head;
        for (int i = 0; i < index-1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }

    static int findMiddle(Node<Integer> head) {
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
//        assert slow != null;
        return slow.data;
    }
}
