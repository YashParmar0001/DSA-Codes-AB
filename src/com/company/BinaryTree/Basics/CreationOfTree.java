package com.company.BinaryTree.Basics;

import java.util.Scanner;

public class CreationOfTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Node root = BinaryTree.createBinaryTree(sc);
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        /*
         Construct the following tree
                 1
               /   \
              /     \
             2       3
            /      /   \
           /      /     \
          4      5       6
                / \
               /   \
              7     8
        */

        BinaryTree.inOrderTraversal(root);
        System.out.println();
        BinaryTree.preOrderTraversal(root);
        System.out.println();
        BinaryTree.postOrderTraversal(root);

        System.out.println("Height : " + BinaryTree.heightOfTree(root));
    }
}

class BinaryTree {
    Scanner sc;
    Node root;

    public BinaryTree() {
        sc = new Scanner(System.in);
    }

    static Node createBinaryTree(Scanner sc) {
        System.out.println("Enter data : ");
        int data = sc.nextInt();

        if (data == -1) return null;

        Node node = new Node(data);

        System.out.println("Enter " + data + "'s left data : ");
        node.left = createBinaryTree(sc);
        System.out.println("Enter " + data + "'s right data : ");
        node.right = createBinaryTree(sc);

        return node;
    }

    static void inOrderTraversal(Node root) {
        if (root == null) return;

        inOrderTraversal(root.left);
        System.out.print(root.data + ", ");
        inOrderTraversal(root.right);
    }

    static void preOrderTraversal(Node root) {
        if (root == null) return;

        System.out.print(root.data + ", ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static void postOrderTraversal(Node root) {
        if (root == null) return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + ", ");
    }

    static int heightOfTree(Node root) {
        if (root == null) return 0;

        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);

        return Math.max(left, right) + 1;
    }
}

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }
}
