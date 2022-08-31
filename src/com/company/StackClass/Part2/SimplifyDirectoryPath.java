package com.company.StackClass.Part2;

import java.util.ArrayDeque;

public class SimplifyDirectoryPath {
    public static void main(String[] args) {
        String path = "/a/./b/..//../c/";
        System.out.println(simplifyPath(path));
    }

    // Explanation
    // https://leetcode.com/problems/simplify-path/discuss/1847526/Best-Explanation-Ever-Possible-oror-Not-a-ClickBait
    static String simplifyPath(String path) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        String[] p = path.split("/");

        for (String s : p) {
            if (!stack.isEmpty() && s.equals("..")) {
                stack.pop();
            }else if (!s.equals("") && !s.equals(".") && !s.equals("..")) {
                stack.push(s);
            }
        }

        if (stack.isEmpty()) return "/";

        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop()).insert(0, "/");
        }

        return ans.toString();
    }
}
