package com.company.BinarySearchTree.Part1;

public class SearchingInTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(searchBST(root, 2).val);
    }

    static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;

        if (val > root.val) {
            return searchBST(root.right, val);
        }

        return searchBST(root.left, val);
    }

    static TreeNode searchBST1(TreeNode root, int val) {
        TreeNode current = root;

        while (current != null) {
            if (current.val == val) {
                return current;
            }else if (current.val < val) current = current.right;
            else current = current.left;
        }

        return null;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {this.val = val;}
    }
}
