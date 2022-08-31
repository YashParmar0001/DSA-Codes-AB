package com.company.BinaryTree.Part1;

import java.util.*;

public class ZigZagOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(zigzagLevelOrder(root));
    }

    static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        ArrayDeque<TreeNode> s1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> s2 = new ArrayDeque<>();
        s1.push(root);

        while (!s1.isEmpty()) {
            List<Integer> currList = new ArrayList<>();

            while (!s1.isEmpty()) {
                TreeNode current = s1.pop();
                currList.add(current.val);
                if (current.left != null) s2.push(current.left);
                if (current.right != null) s2.push(current.right);
            }
            ans.add(currList);
            currList = new ArrayList<>();

            while (!s2.isEmpty()) {
                TreeNode current = s2.pop();
                currList.add(current.val);
                if (current.right != null) s1.push(current.right);
                if (current.left != null) s1.push(current.left);
            }
            if (!currList.isEmpty()) ans.add(currList);
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
