package com.company.StackClass.Basics;

import java.util.ArrayDeque;

public class ReverseWordsInString {
    public static void main(String[] args) {
        String str = "Life should be like Kadane's Algorithm";
        System.out.println(reverseWords(str));
    }

    static String reverseWords(String str) {
        // Stack for storing all words
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            StringBuilder word = new StringBuilder();
            if (str.charAt(i) == ' ') continue; // Skip spaces
            while (i < str.length() && str.charAt(i) != ' ') {
                word.append(str.charAt(i));
                i++;
            }
            stack.push(word.toString());
        }

        StringBuilder ans = new StringBuilder();
        // Now we'll pop all words from stack (So they pop in reverse order) and
        // append to our answer
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
            if (!stack.isEmpty()) ans.append(' ');
        }
        return ans.toString();
    }
}
