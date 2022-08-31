package com.company.Recursion.Part1;

public class PermutationsOfString {
    public static void main(String[] args) {
        permutations("", "abc");
    }

    static void permutations(String processed, String unProcessed) {
        if (unProcessed.isEmpty()) {
            System.out.println(processed);
            return;
        }

        char c = unProcessed.charAt(0);

        for (int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String second = processed.substring(i);

            permutations(first + c + second, unProcessed.substring(1));
        }
    }
}
