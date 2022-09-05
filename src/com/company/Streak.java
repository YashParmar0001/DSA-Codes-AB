package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Streak {
    public static void main(String[] args) {

    }

    static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Node current;
        Queue<Node> queue = new LinkedList<>();
        List<Integer> currList = new ArrayList<>();
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current == null) {
                ans.add(currList);
                if (queue.isEmpty()) return ans;
                queue.offer(null);
                currList = new ArrayList<>();
            }else {
                currList.add(current.val);
                for (Node node : current.children) {
                    queue.offer(node);
                }
            }
        }
        return ans;
    }

    static class Node {
        int val;
        List<Node> children;

        public Node(int val) {this.val = val;}
    }
}
