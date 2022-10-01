package com.company.GreedyAlgorithm.Part2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanEncoding {
    public static void main(String[] args) {
        String s = "abcdef";
        int[] f = {5, 9, 12, 13, 16, 45};
        System.out.println(huffmanCodes(s, f, s.length()));
    }

    static ArrayList<String> huffmanCodes(String S, int[] f, int n) {
        ArrayList<String> ans = new ArrayList<>();
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.freq >= o2.freq) return 1;
            else return -1;
        });
        char[] chars = S.toCharArray();

        for (int i = 0; i < n; i++) {
            queue.offer(new Node(chars[i], f[i], null, null));
        }

        while (queue.size() > 1) {
            Node left = queue.poll();
            Node right = queue.poll();
            Node newNode = new Node('_', left.freq + right.freq, left, right);
            queue.offer(newNode);
        }

        Node treeNode = queue.poll();
        traverse(treeNode, "", ans);
        return ans;
    }

    static void traverse(Node root, String code, ArrayList<String> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(code);
        }
        traverse(root.left, code + '0', list);
        traverse(root.right, code + '1', list);
    }

    static class Node {
        char c;
        int freq;
        Node left, right;
        public Node(char c, int freq, Node left, Node right) {
            this.c = c;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
    }
}
