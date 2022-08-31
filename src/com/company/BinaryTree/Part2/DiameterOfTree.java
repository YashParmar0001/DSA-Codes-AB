package com.company.BinaryTree.Part2;

public class DiameterOfTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(diameterOfBinaryTree1(root));
    }

    // Time : O(n^2)
//    static int diameterOfBinaryTree(TreeNode root) {
//        if (root == null) return 0;
//
//        int ld = diameterOfBinaryTree(root.left);
//        int rd = diameterOfBinaryTree(root.right);
//
//        int lh = height(root.left);
//        int rh = height(root.right);
//        int current = lh + rh;
//
//        return Math.max(current, Math.max(ld, rd));
//    }

    // Time : O(n)
    static int diameterOfBinaryTree1(TreeNode root) {
        int[] ans = new int[1];
        height(root, ans);
        return ans[0];
    }

    static int height(TreeNode root, int[] ans) {
        if (root == null) return 0;

        int lh = height(root.left, ans);
        int rh = height(root.right, ans);
        ans[0] = Math.max(ans[0], lh + rh);
        return Math.max(lh, rh) + 1;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
