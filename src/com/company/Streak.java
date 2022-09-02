package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Streak {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(7);
        System.out.println(averageOfLevels(root));
    }

    static List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        List<Integer> currList = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                double avg = 0;
                for (int e : currList) {
                    avg += e;
                }
                avg /= currList.size();
                ans.add(avg);
                if (queue.isEmpty()) return ans;
                queue.offer(null);
                currList = new ArrayList<>();
            }else {
                currList.add(current.val);
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }
        return ans;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {this.val = val;}
    }
}
