package com.company;

public class Streak {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(0);
        root.right.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        preOrder(pruneTree(root));
    }

    static TreeNode pruneTree(TreeNode root) {
        if (root == null) return root;
        isPresent(root);
        if (root.val == 0 && root.left == null && root.right == null) return null;
        return root;
    }

    static boolean isPresent(TreeNode root) {
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        boolean left, right;
        left = isPresent(root.left);

        right = isPresent(root.right);

        if (!left) root.left = null;
        if (!right) root.right = null;

        return left || right || root.val == 1;
    }

    static void preOrder(TreeNode root) {
        if (root == null) return;

        System.out.print(root.val + ", ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {this.val = val;}
    }
}
