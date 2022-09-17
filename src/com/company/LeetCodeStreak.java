package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeetCodeStreak {
    public static void main(String[] args) {
        String s = "yas";
        Pattern p = Pattern.compile(".y");
        Matcher m = p.matcher(s);
        System.out.println(Pattern.matches(".h", "sh"));
//        System.out.println(palindromePairs(new String[]{"abcd","dcba","lls","s","sssll"}));
    }

    static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j) {
                    String one = words[i] + words[j];
                    if (isPalindrome(one)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(i); temp.add(j);
                        ans.add(temp);
                    }
                }
            }
        }
        return ans;
    }

    static boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        char[] str = s.toCharArray();
        while (i < j) {
            if (str[i] != str[j]) return false;
            i++; j--;
        }
        return true;
    }
}