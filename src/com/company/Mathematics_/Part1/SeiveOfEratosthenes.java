package com.company.Mathematics_.Part1;

import java.util.Arrays;

public class SeiveOfEratosthenes {
    public static void main(String[] args) {
        printPrimeTillN(20);
    }

    // Time complexity : O[nlog(log n)]
    // Space complexity : O(n)
    static void printPrimeTillN(int n) {
        // We are ignoring zeroth position
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i <= n; i++) {
            if(isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) System.out.print(i + ", ");
        }
    }
}
