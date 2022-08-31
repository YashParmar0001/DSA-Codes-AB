package com.company.BitWise.Basics;

public class SetUnsetBit {
    public static void main(String[] args) {
        System.out.println(setBit(6, 0));
        System.out.println(unsetBit(6, 2));
    }

    static int setBit(int n, int i) {
        int mask = 1 << i;
        return n | mask;
    }

    static int unsetBit(int n, int i) {
        int mask = 1 << i;
        return n & ~mask;
    }
}
