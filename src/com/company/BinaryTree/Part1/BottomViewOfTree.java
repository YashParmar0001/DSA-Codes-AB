package com.company.BinaryTree.Part1;

import java.util.*;

// https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
public class BottomViewOfTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        System.out.println(bottomView(root));
    }

    static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, ArrayDeque<Integer>> map = new TreeMap<>();
        queue.offer(new Pair(0, root));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int key = current.hd;
            if (!map.containsKey(key)) {
                map.put(key, new ArrayDeque<>());
            }
            map.get(key).push(current.node.data);

            if (current.node.left != null) queue.offer(new Pair(key-1, current.node.left));

            if (current.node.right != null) queue.offer(new Pair(key+1, current.node.right));
        }

        for (ArrayDeque<Integer> stack : map.values()) {
            ans.add(stack.pop());
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
