package com.company.LinkedListClass.Basics;

public class IntersectionOfTwoLists {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node n2 = new Node(2); head1.next = n2;
        Node n3 = new Node(3); n2.next = n3;
        Node n4 = new Node(4); n3.next = n4;
        Node n5 = new Node(6); n4.next = n5;

        Node head2 = new Node(2);
        Node m2 = new Node(4); head2.next = m2;
        Node m3 = new Node(6); m2.next = m3;
        Node m4 = new Node(8); m3.next = m4;

        Node ans = findIntersection(head1, head2);
        printLL(ans);
    }

    // Answer node for storing intersection
    static Node ans = null;
    // Tail node for keeping track of last node
    static Node tail = null;

    static void push(int data) {
        Node temp = new Node(data);
        if (ans == null) {
            ans = temp;
        }else {
            tail.next = temp;
        }
        tail = temp;
    }

    static Node findIntersection(Node head1, Node head2) {
        Node i = head1;
        Node j = head2;
        while (i != null && j != null) {
            if (i.data == j.data) {
                // Add data into ans
                push(i.data);
                i = i.next;
                j = j.next;
            }else if (i.data < j.data) {
                i = i.next;
            }else {
                j = j.next;
            }
        }
        return ans;
    }

    static class Node {
        int data;
        Node next;
        public Node(){}
        public Node(int data) {
            this.data = data;
        }
    }

    static void printLL(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println(" NULL");
    }
}
