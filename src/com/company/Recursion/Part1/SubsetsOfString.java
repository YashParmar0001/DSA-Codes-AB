package com.company.Recursion.Part1;

import java.util.HashSet;
import java.util.Set;

public class SubsetsOfString {
    public static void main(String[] args) {
        Set<String> ans = subsets("abc");
        for (String s : ans) {
            System.out.println(s);
        }
    }

    // Time : O(2^n)
    // Space complexity = Height of recursion tree
    // To better understand watch video at 57:25
    static Set<String> subsets(String s) {
        Set<String> set = new HashSet<>();
        utilSubsets(s, 0, "", set);

        return set;
    }

    // 1, 11, 53
    static void utilSubsets(String s, int i, String current, Set<String> set) {
        if (i == s.length()) {
            set.add(current);
            return;
        }

        utilSubsets(s, i + 1, current, set);
        utilSubsets(s, i + 1, current + s.charAt(i), set);
    }
}
