package com.company.BitWise.Problems;

public class SwapTwoBits {
    public static void main(String[] args) {
        System.out.println(swapBits(173, 1, 5));
        // 173 --> 10101101
        // 143 --> 10001111 ( Answer )
    }

    static int swapBits(int n, int i, int j) {
        int ithBit = (n >> i) & 1;
        int jthBit = (n >> j) & 1;

        // If both bits are same then we don't have to swap
        if ((ithBit ^ jthBit) == 0) return n;
        // if (ithBit == jthBit) return n;

        int mask = (1 << i) | (1 << j);

        return n ^ mask;
    }
}
