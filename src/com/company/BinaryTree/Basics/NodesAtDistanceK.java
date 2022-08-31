package com.company.BinaryTree.Basics;

public class NodesAtDistanceK {
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

        nodesAtK(root, 2);
    }

    static void nodesAtK(Node root, int k) {
        if (root == null) return;
        if (k == 0) {
            System.out.println(root.data);
            return;
        }

        nodesAtK(root.left, k-1);
        nodesAtK(root.right, k - 1);
    }
}
