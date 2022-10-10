package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LeetCodeStreak {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        System.out.println(findTarget(root, 1));
    }

    static Set<Integer> set = new HashSet<>();
    static boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {this.val = val;}
    }
}
