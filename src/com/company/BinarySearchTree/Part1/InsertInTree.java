package com.company.BinarySearchTree.Part1;

public class InsertInTree {
    public static void main(String[] args) {

    }

    static TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode parent = null, current = root;

        while (current != null) {
            if (val > current.val) {
                parent = current;
                current = current.right;
            }else {
                parent = current;
                current = current.left;
            }
        }

        TreeNode newNode = new TreeNode(val);
        if (parent == null) return newNode;

        if (val > parent.val) {
            parent.right = newNode;
        }else parent.left = newNode;

        return root;
    }

    static TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (val > root.val) {
            root.right = insertIntoBST1(root.right, val);
        }else root.left = insertIntoBST1(root.left, val);

        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {this.val = val;}
    }
}
