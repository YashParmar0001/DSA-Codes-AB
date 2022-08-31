package com.company.BinaryTree.Basics;

public class MinAndMaxInTree {
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(7);
        root.right = new Node(5);
        root.left.right = new Node(60);
        root.right.right = new Node(9);
        root.left.right.left = new Node(1);
        root.left.right.right = new Node(11);
        root.right.right.left = new Node(4);

        System.out.println(findMax(root));
        System.out.println(findMin(root));
    }

    static int findMax(Node root){
        if (root == null) return Integer.MIN_VALUE;

        int result = root.data;
        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);

        result = Math.max(Math.max(result, leftMax), rightMax);

        return result;
    }

    static int findMin(Node root){
        if (root == null) return Integer.MAX_VALUE;

        int result = root.data;
        int leftMin = findMin(root.left);
        int rightMin = findMin(root.right);

        result = Math.min(Math.min(result, leftMin), rightMin);

        return result;
    }
}
