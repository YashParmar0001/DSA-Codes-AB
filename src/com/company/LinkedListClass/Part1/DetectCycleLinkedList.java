package com.company.LinkedListClass.Part1;

// https://leetcode.com/problems/linked-list-cycle/
// https://leetcode.com/problems/linked-list-cycle-ii/
public class DetectCycleLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head.next;
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = head.next;
//        System.out.println(hasCycle(head));
        System.out.println(detectCycle(head).val);
    }

    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow.equals(fast)) return true;
        }
        return false;
    }

    static ListNode hasCycle1(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow.equals(fast)) return slow;
        }
        return null;
    }

    // Floyd's Cycle Detection Algorithm
    static ListNode detectCycle(ListNode head) {
        ListNode current = head;
        ListNode meet = hasCycle1(head);
        if (meet != null) {
            while (current != meet) {
                current = current.next;
                meet = meet.next;
            }
            return current;
        }else {
            return null;
        }
    }
}
