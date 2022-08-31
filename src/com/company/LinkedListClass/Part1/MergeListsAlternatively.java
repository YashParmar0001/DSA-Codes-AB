package com.company.LinkedListClass.Part1;

public class MergeListsAlternatively {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        Node head2 = new Node(4);
        head2.next = new Node(5);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(7);
        head2.next.next.next.next = new Node(8);
//        head2.next.next.next.next.next = new Node(5);
        mergeAlt(head1, head2);
        printLL(head1);
    }

    static void mergeAlt(Node head1, Node head2){
        Node a = head1, b = head2;

        if (a == null) return;
        if (b == null) return;

        Node tail = a;
        Node temp = null;
        int count = 0;

        while (a != null && b != null) {
            if (count % 2 == 0) {
                temp = a.next;
                tail.next = b;
                tail = b;
                a = temp;
            }else {
                temp = b.next;
                tail.next = a;
                tail = a;
                b = temp;
            }
//            a = a.next;
//            b = b.next;
            count++;
        }

        if (a == null) tail.next = b.next;
        if (b == null) tail.next = a.next;
    }

    static class Node {
        int data;
        Node next;
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
