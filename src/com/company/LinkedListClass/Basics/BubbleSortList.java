package com.company.LinkedListClass.Basics;
import com.company.LinkedListClass.Basics.KthNodeFromEnd.Node;

public class BubbleSortList {
    public static void main(String[] args) {
        Node head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(40);
        head.next.next.next = new Node(30);
        printLL(sortLL(head));
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

    static Node sortLL(Node head) {
        if (head == null || head.next == null) return head;
        int length = 4;
        for (int i = 0; i < length-1; i++) {
            Node previous = null;
            Node current = head;
            Node nextNode = current.next;

            while (current.next != null) {
                if (current.data > current.next.data) {
                    if (previous == null) {
                        current.next = nextNode.next;
                        nextNode.next = current;
                        previous = nextNode;
                        head = previous;
                    }else {
                        nextNode = current.next;
                        current.next = nextNode.next;
                        previous.next = nextNode;
                        nextNode.next = current;
                        previous = nextNode;
                    }
                }else {
                    previous = current;
                    current = current.next;
                }
            }
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
