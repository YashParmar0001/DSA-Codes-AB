package com.company.BinarySearchTree.Part2;

public class IsValidBST {
    public static void main(String[] args) {

    }

    static boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean isValid(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;

        if (root.val <= minValue || root.val >= maxValue) return false;

        return isValid(root.left, minValue, root.val) && isValid(root.right, root.val, maxValue);
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {this.val = val;}
    }
}
