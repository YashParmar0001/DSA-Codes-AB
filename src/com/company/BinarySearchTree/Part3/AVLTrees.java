package com.company.BinarySearchTree.Part3;

public class AVLTrees {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);
        preOrder(root);
    }

    static TreeNode leftRotate(TreeNode x) {
        // Save the nodes
        TreeNode y = x.right;
        TreeNode A = y.left;

        // Perform rotations
        y.left = x;
        x.right = A;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    static TreeNode rightRotate(TreeNode x) {
        TreeNode y = x.left;
        TreeNode A = y.right;

        y.right = x;
        x.left = A;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    static TreeNode insert(TreeNode root, int key) {
        if (root == null) return new TreeNode(key);

        // Normal searching / inserting as BST
        if (key < root.val) {
            root.left = insert(root.left, key);
        }else if (key > root.val) {
            root.right = insert(root.right, key);
        }else {
            return root;
        }

        // Updating height of ancestor node
        root.height = 1 + Math.max(height(root.left), height(root.right));

        int balance = getBalance(root);

        // 1. Left-Left Case
        if (balance > 1 && key < root.left.val) {
            return rightRotate(root);
        }

        // 2. Right-Right Case
        if (balance < -1 && key > root.right.val) {
            return leftRotate(root);
        }

        // 3. Left-Right Case
        if (balance > 1 && key > root.left.val) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // 4. Right-Left Case
        if (balance < -1 && key < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    static int height(TreeNode node) {
        if (node == null) return 0;
        return node.height;
    }

    static int getBalance(TreeNode node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    static void preOrder(TreeNode root) {
        if (root == null) return;

        System.out.print(root.val + ", ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static class TreeNode {
        int val, height;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.height = 1;
        }
    }
}