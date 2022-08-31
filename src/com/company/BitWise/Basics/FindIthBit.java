package com.company.BitWise.Basics;

public class FindIthBit {
    public static void main(String[] args) {
        System.out.println(fidnIthBit(5, 1));
    }

    static int fidnIthBit(int n, int i) {
        int mask = 1 << i;

        int result = n & mask;

        if (result == 0) return 0;

        return 1;
    }
}
