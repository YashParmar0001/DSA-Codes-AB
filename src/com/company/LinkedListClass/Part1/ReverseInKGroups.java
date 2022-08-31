package com.company.LinkedListClass.Part1;

public class ReverseInKGroups {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode temp = head.next.next.next;
        temp.next = new ListNode(5);
        temp.next.next = new ListNode(6);
        temp.next.next.next = new ListNode(7);
        temp.next.next.next.next = new ListNode(8);
        printLL(head);
        ListNode newHead = reverseKGroup(head, 3);
        printLL(newHead);
    }

    // TODO : Do it recursively
    static ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head, prevFirst = null, newHead = null;
        // We're comparing two windows at a time
        while (current != null) {
            int count = 0;
            ListNode prev = null, first = current;
            // Reversing k length of Linked List
            while (current != null && count < k) {
                ListNode temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
                count++;
            }
            // If we're doing for first two windows which has no new head then...
            if (newHead == null) {
                newHead = prev;
            }else { // Now we've new head so connect two parts of Linked List
                prevFirst.next = prev;
            }
            prevFirst = first;
        }
        return newHead;
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
