package com.company.BinaryTree.Part3;

import java.util.ArrayList;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        System.out.println(lowestCommonAncestor1(root, root.left, root.right).val);
    }

    static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        // For case 1
        if (root.val == p.val || root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);

        // Case 3 + Case 4 : If left & right both are null then null will be returned
        if (left == null) return right;
        if (right == null) return left;

        // Case 2 : If left & right both are not null then return current node
        return root;
    }

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> ans_p = new ArrayList<>();
        ArrayList<TreeNode> ans_q = new ArrayList<>();
        isPresent(root, p, ans_p);
        isPresent(root, q, ans_q);
        int i = ans_p.size()-1, j = ans_q.size()-1;

        while (i >= 0 && j >= 0 && ans_p.get(i).val == ans_q.get(j).val) {
            i--; j--;
        }

        if (i == ans_p.size()-1) return null;
        return ans_p.get(i+1);
    }

    static boolean isPresent(TreeNode root, TreeNode target, ArrayList<TreeNode> ans) {
        if (root == null) return false;
        if (root.val == target.val) return true;
        if (isPresent(root.left, target, ans) || isPresent(root.right, target, ans)) {
            ans.add(root);
            return true;
        }
        return false;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
