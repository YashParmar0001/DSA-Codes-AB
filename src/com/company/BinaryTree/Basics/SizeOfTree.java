package com.company.BinaryTree.Basics;

public class SizeOfTree {
    public static void main(String[] args) {
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

        System.out.println(getSize(root));
    }

    static int getSize(Node root) {
        if (root == null) return 0;
        return getSize(root.left) + getSize(root.right) + 1;
    }
}
