package com.company.BitWise.Basics;

public class CountSetBits {
    public static void main(String[] args) {
        System.out.println(countSetBits(9));
        System.out.println(countSetBits1(9));
    }

    // Time : O(log2(n))
    static int countSetBits(int n) {
        int count = 0;
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1) count++;
        }
        return count;
    }

    // Optimized
    static int countSetBits1(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n & (n-1);
        }
        return count;
    }
}
