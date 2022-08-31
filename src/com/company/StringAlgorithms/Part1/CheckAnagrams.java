package com.company.StringAlgorithms.Part1;

import java.util.Arrays;

public class CheckAnagrams {
    public static void main(String[] args) {
        System.out.println(isAnagram1("yash42", "aysh34"));
    }

    static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        char[] str1_ = str1.toCharArray();
        char[] str2_ = str2.toCharArray();

        Arrays.sort(str1_);
        Arrays.sort(str2_);

        for (int i = 0; i < str1.length(); i++) {
            if (str1_[i] != str2_[i]) return false;
        }

        return true;
    }

    static boolean isAnagram1(String str1, String str2) {

        if (str1.length() != str2.length()) return false;

        int[] ascii = new int[256];

        for (int i = 0; i < str1.length(); i++) {
            ascii[str1.charAt(i)]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            ascii[str2.charAt(i)]--;
        }

        // Checking
        // No need to check entire array
        for (int i = 0; i < str1.length(); i++) {
            if (ascii[str1.charAt(i)] != 0) return false;
        }

        return true;
    }
}
