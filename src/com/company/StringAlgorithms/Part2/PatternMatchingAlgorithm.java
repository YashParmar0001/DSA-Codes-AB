package com.company.StringAlgorithms.Part2;

public class PatternMatchingAlgorithm {
    public static void main(String[] args) {
        String str = "abcabdabbdabcdbdaab";
        matchPattern(str, "bda");
    }

    // Time complexity : O(n*m)
    static void matchPattern(String str, String pattern) {
        int n = str.length();
        int m = pattern.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            for (; j < m; j++) {
                if (str.charAt(i + j) != pattern.charAt(j)) break;
            }
            if (j == m) {
                System.out.println(i);
                // We don't need to check again all letters of pattern in string
                i += m - 1;
            }
        }
    }

    // Code by myself
    // Rabin Karp Algorithm
}
