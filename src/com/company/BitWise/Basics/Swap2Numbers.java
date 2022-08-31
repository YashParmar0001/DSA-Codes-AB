package com.company.BitWise.Basics;

public class Swap2Numbers {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a = " + a + " and b = " + b);
    }
}
