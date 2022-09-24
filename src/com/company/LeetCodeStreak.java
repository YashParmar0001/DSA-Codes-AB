package com.company;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeStreak {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.left = new TreeNode(-3);
        System.out.println(pathSum(root, -5));
    }

    static List<List<Integer>> ans = new ArrayList<>();
    static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        util(root, 0, targetSum, new ArrayList<>());
        return ans;
    }

    static void util(TreeNode root, int sum, int targetSum, List<Integer> currList) {
        if (root == null) {
            return;
        }
        sum += root.val;
        currList.add(root.val);
        if (sum == targetSum && isLeaf(root)) {
            ans.add(currList);
            return;
        }

        util(root.left, sum, targetSum, new ArrayList<>(currList));
        util(root.right, sum, targetSum, new ArrayList<>(currList));
    }

    static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}