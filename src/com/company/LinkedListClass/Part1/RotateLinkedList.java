package com.company.LinkedListClass.Part1;

public class RotateLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(11);
        head.next = new ListNode(23);
        head.next.next = new ListNode(17);
        head.next.next.next = new ListNode(21);
        head.next.next.next.next = new ListNode(17);
        printLL(head);
        ListNode newHead = rotateRight(head, 2);
        printLL(newHead);
    }

    static ListNode rotateRight(ListNode head, int k) {
        int length = findLength(head);
        k %= length;
        if (k == 0) return head;
        ListNode i = head, j;
        int count = 0;
        while (count < length - k - 1) {
            i = i.next;
            count++;
        }
        j = i; count = 0;
        while (count < k) {
            j = j.next;
            count++;
        }

        j.next = head;
        head = i.next;
        i.next = null;
        return head;
    }

    static int findLength(ListNode head) {
        ListNode current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
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
