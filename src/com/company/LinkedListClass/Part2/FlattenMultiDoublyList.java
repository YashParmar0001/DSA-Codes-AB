package com.company.LinkedListClass.Part2;

public class FlattenMultiDoublyList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.child = new Node(2);
        head.child.child = new Node(3);
        Node ans = flatten(head);
        System.out.println(ans.val);
        System.out.println(ans.child.val);
    }

    static Node flatten(Node head) {
        util(head);
        return head;
    }

    static Node util(Node head) {
        if (head == null) return null;
        if (head.next == null) {
            if (head.child != null) {
                head.next = head.child;
                head.next.prev = head;
                return util(head.next);
            }else return head;
            // return util(head.next);
        }
        Node current = head;
        Node temp;
        while (current.next != null) {
            if (current.child != null) {
                temp = current.next;
                current.next = current.child;
                current.next.prev = current;
                current.child = null;
                Node cur = util(current);
                temp.prev = cur;
                cur.next = temp;
            }
            current = current.next;
        }
        return current;
    }

    static void printLL(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " --> ");
            current = current.next;
        }
        System.out.println(" NULL");
    }

    static class Node {
        int val;
        Node prev, next, child;
        public Node(int val) {this.val = val;}
    }
}
