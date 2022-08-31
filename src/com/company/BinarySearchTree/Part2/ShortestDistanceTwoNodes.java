package com.company.BinarySearchTree.Part2;

public class ShortestDistanceTwoNodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(20);
        root.right = new TreeNode(60);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(40);
        root.left.right.left = new TreeNode(30);
        root.right.right = new TreeNode(70);

        System.out.println(shortestDistance(root, new TreeNode(40), new TreeNode(70)));
    }

    static int shortestDistance(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null) return 0;

        if (root.val < n1.val && root.val < n2.val) {
            return shortestDistance(root.right, n1, n2);
        }

        if (root.val > n1.val && root.val > n2.val) {
            return shortestDistance(root.left, n1, n2);
        }

        return distance(root, n1) + distance(root, n2);
    }

    static int distance(TreeNode root, TreeNode node) {
        if (root == null || root.val == node.val) return 0;
        if (node.val < root.val) {
            return 1 + distance(root.left, node);
        }
        return 1 + distance(root.right, node);
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {this.val = val;}
    }
}
