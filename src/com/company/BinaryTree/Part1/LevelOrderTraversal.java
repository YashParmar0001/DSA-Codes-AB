package com.company.BinaryTree.Part1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        System.out.println(levelOrder(root));
    }

    static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        // Using linked-list so that we can add null values
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        List<Integer> currList = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                ans.add(currList);
                if (queue.isEmpty()) return ans;
                queue.offer(null);
                currList = new ArrayList<>();
            }else {
                currList.add(cur.val);

                if (cur.left != null) queue.offer(cur.left);

                if (cur.right != null) queue.offer(cur.right);
            }
        }

        return ans;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
