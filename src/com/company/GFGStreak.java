package com.company;

public class GFGStreak {
    public static void main(String[] args) {

    }

    static long noOfWays(long n){
        return 2 + 2*(n-1) + (n-2)*(n-1);
    }
}
