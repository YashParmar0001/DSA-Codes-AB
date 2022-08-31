package com.company.Mathematics_.Basics;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(check(121));
    }

    // Time complexity : O(log10(n))
    // Number of digits = log10(n) + 1
    static boolean check(int num) {
        int num1 = num;
        int rev = 0;
        while (num1 != 0) {
            int last = num1 % 10;
            rev = rev * 10 + last;
            num1 /= 10;
        }
        return rev == num;
    }
}