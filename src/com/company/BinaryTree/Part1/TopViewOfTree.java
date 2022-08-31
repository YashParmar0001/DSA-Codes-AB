package com.company.BinaryTree.Part1;

import java.util.*;

public class TopViewOfTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        System.out.println(topView(root));
    }

    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        queue.offer(new Pair(0, root));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int key = current.hd;
            if (!map.containsKey(key)) {
                map.put(key, current.node.data);
            }

            if (current.node.left != null) queue.offer(new Pair(key-1, current.node.left));

            if (current.node.right != null) queue.offer(new Pair(key+1, current.node.right));
        }

        ans.addAll(map.values());

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
