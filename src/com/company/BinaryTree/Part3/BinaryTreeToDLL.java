package com.company.BinaryTree.Part3;

public class BinaryTreeToDLL {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right.right = new Node(6);
        root.right.right.left = new Node(7);
        Node head = bToDLL(root);
        printDLL(head);
    }

    static Node prev = null, head = null;
    static Node bToDLL(Node root) {
        bToDLLUtil(root);
        return head;
    }

    static void bToDLLUtil(Node root) {
        if (root == null) return;

        bToDLLUtil(root.left);
        if (prev == null) {
           head = root;
        }else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        bToDLLUtil(root.right);
    }

    static class Node {
        int data;
        Node left, right;
        public Node(int data) {this.data = data;}
    }

    static void printDLL(Node head) {
        if (head == null) return;
        Node current = head;
        while (current != null) {
            System.out.print(current.data + ", ");
            current = current.right;
        }
    }
}
