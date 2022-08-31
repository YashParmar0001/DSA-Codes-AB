package com.company.StringAlgorithms.Part2;

public class CheckStringRotations {
    public static void main(String[] args) {
        System.out.println(isRotational("abcd", "cdab"));
    }

    static boolean isRotational(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String doubleString = s1 + s1;
        return doubleString.contains(s2);
    }

    // Try another approaches
}
