package com.company.LinkedListClass.Part1;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        printLL(reverseList1(head));
    }

    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head.next;
        ListNode newHead = reverseList1(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
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
