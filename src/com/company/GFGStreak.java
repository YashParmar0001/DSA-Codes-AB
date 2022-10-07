package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;

public class GFGStreak {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(4);
        root.right.left = new Node(2);
        root.right.left.right = new Node(5);
        flatten(root);
        printLL(root);
    }

    static Node lastNode;
    public static void flatten(Node root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            lastNode = root;
            return;
        }
        if (root.left == null) {
            flatten(root.right);
        }else {
            Node temp = root.right;
            root.right = root.left;
            root.left = null;
            flatten(root.right);
            if (temp != null) {
                lastNode.right = temp;
                flatten(lastNode.right);
            }
        }
    }

    static void printLL(Node root) {
        Node current = root;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.right;
        }
        System.out.println(" NULL");
    }

    static class Node {
        int data;
        Node left, right;
        public Node(int data) {this.data = data;}
    }
}
