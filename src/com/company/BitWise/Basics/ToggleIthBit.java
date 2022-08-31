package com.company.BitWise.Basics;

public class ToggleIthBit {
    public static void main(String[] args) {
        System.out.println(toggle(5, 2));
        System.out.println(setBit(5, 1));
    }

    static int toggle(int n, int i) {
        int mask = 1 << i;

        return n ^ mask;
    }

    static int setBit(int n, int i) {
        int mask = 1 << i;

        return n | mask;
    }
}
