package com.company.Mathematics_.Part1;

public class FastPower {
    public static void main(String[] args) {
        System.out.println(power(3, 10));
    }

    // Time : O(log n)
    static int power(int a, int b) {
        if (b == 0) return 1;

        int halfAns = power(a, b/2);

        int ans = halfAns * halfAns;

        if (b % 2 != 0) ans *= a;

        return ans;
    }
}
