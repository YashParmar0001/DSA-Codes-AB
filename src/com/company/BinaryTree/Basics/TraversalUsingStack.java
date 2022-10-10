package com.company.BinaryTree.Basics;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class TraversalUsingStack {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

//        inOrderTraversal(root);
//        System.out.println();
        preOrderTraversal(root);
//        System.out.println();
//        System.out.println(postorderTraversal(root));
    }

    static void inOrderTraversal(Node root) {
        if (root == null) return;

        ArrayDeque<Node> stack = new ArrayDeque<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            System.out.print(current.data + ", ");

            current = current.right;
        }
    }

    static void preOrderTraversal(TreeNode root) {
        if (root == null) return;

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                System.out.print(current.val + ", ");
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            current = current.right;
        }
    }

    static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        ArrayDeque<TreeNode> s1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> s2 = new ArrayDeque<>();

        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode current = s1.pop();

            s2.push(current);
            if (current.left != null) s1.push(current.left);
            if (current.right != null) s2.push(current.right);
        }

        while (!s2.isEmpty()) {
            ans.add(s2.pop().val);
        }

        return ans;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
