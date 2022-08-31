package com.company.Mathematics_.Basics;

public class TrailingZeros {
    public static void main(String[] args) {
        System.out.println(findZeros(125));
    }

    static int findZeros(int n) {
        int ans = 0;
        while (n > 0) {
            ans += n / 5;
            n /= 5;
        }
        return ans;
    }
}
