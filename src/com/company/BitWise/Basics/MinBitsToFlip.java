package com.company.BitWise.Basics;

public class MinBitsToFlip {
    public static void main(String[] args) {
        int start = 3;
        int goal = 4;
        System.out.println(minBitFlips(start, goal));
    }

    static int minBitFlips(int start, int goal) {
        int count = 0;
        while (start > 0 || goal > 0) {
            if ((start & 1) != (goal & 1)) {
                count++;
            }
            start >>= 1;
            goal >>= 1;
        }
        return count;
    }
}
