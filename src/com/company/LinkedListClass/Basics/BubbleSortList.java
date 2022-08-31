package com.company.LinkedListClass.Basics;
import com.company.LinkedListClass.Basics.KthNodeFromEnd.Node;

public class BubbleSortList {
    public static void main(String[] args) {
        Node n1 = new Node(3);
        Node n2 = new Node(2);
        Node n3 = new Node(4);
        Node n4 = new Node(1);
        Node n5 = new Node(7);
        Node n6 = new Node(6);
        Node n7 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        Node head = bubbleSort(n1);
        printLL(head);
    }

    static Node bubbleSort(Node head) {
        Node node_i = head;
        Node node_j;
        while (node_i.next != null) {
            node_j = head;
            while (node_j.next != null) {
                if (node_j.data > node_j.next.data) {
                    swap(node_j, node_j.next);
                }
                node_j = node_j.next;
            }
            node_i = node_i.next;
        }
        return head;
    }

    static void printLL(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println(" NULL");
    }

    // Function that only swaps data of two nodes
    static void swap(Node first, Node second) {
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
    }
}
