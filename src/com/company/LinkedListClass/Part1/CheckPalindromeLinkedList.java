package com.company.LinkedListClass.Part1;

// https://leetcode.com/problems/palindrome-linked-list/discuss/64501/Java-easy-to-understand
public class CheckPalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }

    // We can do it by reversing right half of Linked List
    static boolean isPalindrome(ListNode head) {
        // To find middle point
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverseList(slow);
        fast = head;
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return true;
    }

    static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null, current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
}
