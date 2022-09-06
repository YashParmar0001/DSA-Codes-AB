package com.company.BinarySearchTree.Part2;

public class ConstructFromPreorder {
    public static void main(String[] args) {
        int[] preorder = {20, 10, 5, 15, 30};
        TreeNode root = bstFromPreorder(preorder);
        preOrder(root);
    }

    static TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder, 0, preorder.length-1);
    }

    static TreeNode construct(int[] preorder, int left, int right) {
        if (left > right) return null;
        TreeNode newNode = new TreeNode(preorder[left]);
        int i = left;
        for (; i <= right; i++) {
            if (preorder[i] > preorder[left]) break;
        }
        newNode.left = construct(preorder, left+1, i-1);
        newNode.right = construct(preorder, i, right);

        return newNode;
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
