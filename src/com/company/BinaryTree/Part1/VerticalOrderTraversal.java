package com.company.BinaryTree.Part1;

import java.util.*;

public class VerticalOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);

        System.out.println(verticalOrder(root));
    }

    static ArrayList<Integer> verticalOrder(Node root) {
        if (root == null) return null;
        // TreeMap gives sorted order of the keys
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, root));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int key = current.hd;
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(current.node.data);

            if (current.node.left != null) queue.offer(new Pair(key-1, current.node.left));

            if (current.node.right != null) queue.offer(new Pair(key+1, current.node.right));
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (ArrayList<Integer> e : map.values()) {
            ans.addAll(e);
        }
        return ans;
    }

    static class Pair {
        int hd;
        Node node;
        public Pair(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }

    static class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
        }
    }
}
