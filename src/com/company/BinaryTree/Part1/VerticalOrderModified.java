package com.company.BinaryTree.Part1;

import java.util.*;

public class VerticalOrderModified {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println(verticalTraversal(root));
    }

    static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0, root));
        Map<Integer, TreeMap<Integer, ArrayList<Integer>>> map = new TreeMap<>();

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int key = current.hd;
            int row = current.row;
            if (!map.containsKey(key)) {
                TreeMap<Integer, ArrayList<Integer>> temp = new TreeMap<>();
                temp.put(row, new ArrayList<>());
                map.put(key, temp);
            }else {
                if (!map.get(key).containsKey(row)) map.get(key).put(row, new ArrayList<>());
            }
            map.get(key).get(row).add(current.node.val);

            if (current.node.left != null) queue.offer(new Pair(key-1, row+1, current.node.left));

            if (current.node.right != null) queue.offer(new Pair(key+1, row+1, current.node.right));
        }

        for (TreeMap<Integer, ArrayList<Integer>> submap : map.values()) {
            for (ArrayList<Integer> list : submap.values()) {
                Collections.sort(list);
            }
        }

        List<Integer> currList = new ArrayList<>();
        for (TreeMap<Integer, ArrayList<Integer>> submap : map.values()) {
            for (ArrayList<Integer> list : submap.values()) {
                currList.addAll(list);
            }
            ans.add(currList);
            currList = new ArrayList<>();
        }

        return ans;
    }

    static class Pair {
        int hd;
        int row;
        TreeNode node;
        public Pair(int hd, int row, TreeNode node) {
            this.hd = hd;
            this.row = row;
            this.node = node;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
