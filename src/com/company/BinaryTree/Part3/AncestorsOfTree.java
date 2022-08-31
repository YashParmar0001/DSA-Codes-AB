package com.company.BinaryTree.Part3;

import java.util.ArrayList;

public class AncestorsOfTree {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right.right = new Node(6);
        root.right.right.left = new Node(7);
        int target = 7;

        System.out.println(Ancestors(root, target));
    }

    static ArrayList<Integer> Ancestors(Node root, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        isPresent(root, target, ans);
        return ans;
    }

    static boolean isPresent(Node root, int target, ArrayList<Integer> ans) {
        if (root == null) return false;
        if (root.data == target) return true;

        if (isPresent(root.left, target, ans) || isPresent(root.right, target, ans)) {
            ans.add(root.data);
            return true;
        }

        return false;
    }

    static class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
        }
    }
}
