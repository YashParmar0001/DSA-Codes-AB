package com.company.BinaryTree.Part1;

import java.util.ArrayList;

public class LeftSideView {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        System.out.println(leftView(root));
    }

    static ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        int level = 0;
        leftView(root, level, ans);
        return ans;
    }

    static void leftView(Node root, int level, ArrayList<Integer> ans) {
        if (root == null) return;

        if (ans.size() == level) ans.add(root.data);

        leftView(root.left, level+1, ans);
        leftView(root.right, level+1, ans);
    }

    static class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
        }
    }
}
