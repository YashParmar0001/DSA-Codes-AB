package com.company.LinkedListClass.Basics;

public class PalindromeCheck {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2); head.next = n2;
        ListNode n3 = new ListNode(2); n2.next = n3;
        ListNode n4 = new ListNode(1); n3.next = n4;
        System.out.println(isPalindrome(head));
    }

    static boolean isPalindrome(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        while (i < j) {
            if (nums[i] != nums[j]) return false;
            i++; j--;
        }
        return true;
    }

    static boolean isPalindrome(ListNode head) {
        int[] ans = new int[findLength(head)];
        int index = 0;
        ListNode current = head;
        while (current != null) {
            ans[index] = current.data;
            index++;
            current = current.next;
        }
        return isPalindrome(ans);
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
        int data;
        ListNode next;
        public ListNode() {}
        public ListNode(int data) {
            this.data = data;
        }
        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }
}
