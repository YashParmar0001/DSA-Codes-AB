package com.company.StackClass.Basics;

import java.util.ArrayDeque;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("["));
    }

    static boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }else if (!stack.isEmpty()) {
                char c = stack.pop();
                if (c == '{' && s.charAt(i) != '}') return false;
                else if (c == '[' && s.charAt(i) != ']') return false;
                else if (c == '(' && s.charAt(i) != ')') return false;
            }else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
