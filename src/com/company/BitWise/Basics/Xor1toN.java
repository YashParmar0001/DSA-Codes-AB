package com.company.BitWise.Basics;

public class Xor1toN {
    public static void main(String[] args) {
        System.out.println(xor1toN(9));
    }

    // Check by ex-oring manually
    static int xor1toN(int n) {
        if (n % 4 == 0) return n;
        else if (n % 4 == 1) return 1;
        else if (n % 4 == 2) return n + 1;
        else return 0;
    }
}
