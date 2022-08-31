package com.company.Recursion.Part1;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(findSum(0));
    }

    // Formulae to count number of digits : log10(N) + 1
    // Why log10 --> How many times you can divide a number with 10
    // Time : O(logN), Space : O(logN)
    static int findSum(int num) {
        if (num == 0) return 0;

        int last = num % 10;

        return last + findSum(num/10);
    }
}
