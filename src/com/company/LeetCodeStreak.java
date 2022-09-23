package com.company;

public class LeetCodeStreak {
    public static void main(String[] args) {
        System.out.println(concatenatedBinary(12));
    }

    static int concatenatedBinary(int n) {
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            int bitLen = (int) (Math.log(i) / Math.log(2)) + 1;
            ans = ((ans << bitLen) + i) % 1000000007;
        }
        return (int) ans;
    }
}