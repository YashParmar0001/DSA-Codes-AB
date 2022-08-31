package com.company.BitWise.Problems;

public class Reverse32BitInteger {
    public static void main(String[] args) {
        System.out.println(reverse32BitInteger(10));
        System.out.println(reverse32BitInteger1(10));
    }

    static long reverse32BitInteger(long n) {
        long result = 0;
        int i = 0;
        while (i <= 31) {
            if ((n & (1L << i)) != 0) {
                result += (1L << 31-i);
            }
            i++;
        }
        return result;
    }

    // Optimized approach
    static long reverse32BitInteger1(long n) {
        long result = n;
        for (int i = 0; i <= 15; i++) {
            result = swapBits(result, i, 31-i);
        }
        return result;
    }

    static long swapBits(long n, int i, int j) {
        long ithBit = ((n >> i) & 1);
        long jthBit = (n >> j) & 1;

        // If both bits are same then we don't have to swap
        if ((ithBit ^ jthBit) == 0) return n;
        // if (ithBit == jthBit) return n;

        long mask = (1L << i) | (1L << j);

        return n ^ mask;
    }
}
