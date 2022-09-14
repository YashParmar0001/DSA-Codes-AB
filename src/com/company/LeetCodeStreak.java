package com.company;

import java.util.HashSet;
import java.util.Set;

public class LeetCodeStreak {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.right.right = new TreeNode(1);
        System.out.println(pseudoPalindromicPaths(root));
    }

    static int pseudoPalindromicPaths (TreeNode root) {
        Set<Integer> set = new HashSet<>();
        util2(root, set);
        return ans;
    }

    static int ans = 0;

    static void util2(TreeNode root, Set<Integer> set) {
        if (root == null) return;
//        Set<Integer> newSet = new HashSet<>(set);

        if (set.contains(root.val)) set.remove(root.val);
        else set.add(root.val);

        if (root.left == null && root.right == null) {
            if (set.size() == 0 || set.size() == 1) {
                ans += 1;
            }
        }
        util2(root.left, new HashSet<>(set)); util2(root.right, new HashSet<>(set));
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}