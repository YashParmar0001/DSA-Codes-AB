package com.company.BinaryTree.Part1;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        List<Integer> ans = inorderTraversal(root);
        System.out.println(ans);
    }

    static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {
                ans.add(current.val);
                current = current.right;
            }else {
                TreeNode temp = current.left;
                while (temp.right != null && temp.right != current) {
                    temp = temp.right;
                }

                if (temp.right == current) {
                    temp.right = null;
                    ans.add(current.val);
                    current = current.right;
                }else {
                    temp.right = current;
                    current = current.left;
                }
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
