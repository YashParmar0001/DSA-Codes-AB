package com.company.BinaryTree.Part1;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(rightSideView(root));
    }

    static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        int level = 0;
        rightSideView(root, level, ans);
        return ans;
    }

    static void rightSideView(TreeNode root, int level, List<Integer> ans) {
        if (root == null) return;

        if (ans.size() == level) {
            ans.add(root.val);
        }

        rightSideView(root.right, level+1, ans);
        rightSideView(root.left, level+1, ans);
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
