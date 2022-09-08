package com.company;

import java.util.ArrayList;
import java.util.List;

public class Streak {
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
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
