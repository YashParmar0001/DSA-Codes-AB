package com.company.StringAlgorithms.Part1;

public class ReverseWordsInString {
    public static void main(String[] args) {
        String str = "I am the boss !";
        System.out.println(reverseWords(str));
    }

    static String reverseWords(String str) {
        char[] arr = str.toCharArray();
        int start = 0;
        int end = 0;
        for (; end < str.length(); end++) {
            if (arr[end] == ' ') {
                reverse(arr, start, end - 1);
                start = end + 1;
            }
        }
        // Last word will not be reversed
        reverse(arr, start, end - 1);

        // Reverse whole string
        reverse(arr, 0, arr.length - 1);

        return new String(arr);
    }

    static void reverse(char[] str, int i, int j) {
        while (i < j) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;

            i++; j--;
        }
    }
}
