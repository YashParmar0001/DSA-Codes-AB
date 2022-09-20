package com.company;

public class GFGStreak {
    public static void main(String[] args) {
        System.out.println(numberOfSquares(8));
    }

    public static long numberOfSquares(long base) {
        long n = (base - 2)/2L;
        return (n*(n+1))/2L;
    }
}
