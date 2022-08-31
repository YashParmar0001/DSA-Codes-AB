package com.company.Mathematics_.Part1;

import java.util.ArrayList;

public class PrimeFactors {
    public static void main(String[] args) {
        printPrimeFactors(12246);
        seive();
        ArrayList<Integer> ans = getFactorization(12246);
        for (int factor : ans) {
            System.out.print(factor + ", ");
        }
    }

    // O(root N) time
    static void printPrimeFactors(int n) {
        // First we'll check for 2
        while (n % 2 == 0) {
            System.out.print(2 + ", ");
            n /= 2;
        }

        // Now n must be odd at this point
        // i = i + 2 is for checking only odd numbers
        for (int i = 3; i * i <= n; i += 2) {
            // While i divides n, print i and divide n
            while (n % i == 0) {
                System.out.print(i + ", ");
                n /= i;
            }
        }
        System.out.println();

        // This condition is to handle the case when
        // n is a prime number greater than 2
        if (n > 2) System.out.println(n);
    }


    // O(log n) for Prime Factorization
    static final int MAXN = 100001;

    static int[] spf = new int[MAXN];

    // Calculating SPF (Smallest Prime Factor) for every number till MAXN
    // Time : O(loglogn) --> Seive of Eratosthenes
    static void seive() {
        spf[1] = 1;
        // Marking smallest prime factor for every number to be itself
        for (int i = 2; i < MAXN; i++) {
            spf[i] = i;
        }

        // Marking 2 as spf for all even numbers
        for (int i = 4; i < MAXN; i += 2) {
            spf[i] = 2;
        }

        for (int i = 3; i * i < MAXN; i++) {
            // Checking if i is prime
            if (spf[i] == i) {
                // Marking spf for all numbers divisible by i
                for (int j = i * i; j < MAXN; j+=i) {
                    // Checking if it's not previously marked
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
    }

    static ArrayList<Integer> getFactorization(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        while (n != 1) {
            ans.add(spf[n]);
            n /= spf[n];
        }
        return ans;
    }

}
