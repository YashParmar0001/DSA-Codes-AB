package com.company.LinkedListClass.Part2;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(8);
        head1.next.next.next = new ListNode(10);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(5);
        head2.next.next.next = new ListNode(9);
        ListNode head = mergeTwoLists(head1, head2);
        printLL(head);
    }

    static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode head = null, tail = null;
        ListNode a = head1, b = head2;

        if (a == null) return b;
        if (b == null) return a;

        if (a.val <= b.val) {
            head = a;
            tail = a;
            a = a.next;
        }else {
            head = b;
            tail = b;
            b = b.next;
        }

        while (a != null && b != null) {
            if (a.val <= b.val) {
                tail.next = a;
                tail = a;
                a = a.next;
            }else {
                tail.next = b;
                tail = b;
                b = b.next;
            }
        }

        if (a == null) tail.next = b;
        if (b == null) tail.next = a;

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    static void printLL(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " --> ");
            current = current.next;
        }
        System.out.println(" NULL");
    }
}
