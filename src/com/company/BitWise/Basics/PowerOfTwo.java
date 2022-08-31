package com.company.BitWise.Basics;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPower(5));
    }

    static boolean isPower(int n) {
        return (n & (n - 1)) == 0;
    }
}
