package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GFGStreak {
    public static void main(String[] args) {
        String s = "44334521";
        System.out.println(minLength(s, s.length()));
    }

    static int minLength(String s, int n) {
        Set<String> set = new HashSet<>(Arrays.asList("12", "21", "34", "43", "56",
                "65", "78", "87", "09", "90"));
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int index = 1;
        char[] digits = s.toCharArray();
        stack.push(digits[0]);
        while (index < s.length()) {
            String digit = "" + stack.peek() + digits[index];
            if (set.contains(digit)) {
                stack.pop();
            }else {
                stack.push(digits[index]);
            }
            index++;
        }
        return stack.size();
    }
}
