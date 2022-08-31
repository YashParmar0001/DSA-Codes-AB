package com.company.Mathematics_.Basics;

public class GCDandLCM {
    public static void main(String[] args) {
        System.out.println(findGCDEuclidModified(36, 24));
        System.out.println(findLCM(36, 24));
    }

    // Time : O(smaller number)
    static int findGCD(int a, int b) {
        for (int i = Math.min(a, b); i > 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }

    // Time : O(smaller number)
    // Worst case --> When gcd is 1
    static int findGCDEuclid(int a, int b) {
        if (a == b) return a;

        if (a > b) return findGCDEuclid(a - b, b);
        else return findGCDEuclid(a, b - a);
    }

    static int findGCDEuclidModified(int a, int b) {
        if (a < b) return findGCDEuclidModified(b, a);

        if (b == 0) return a;

        return findGCDEuclidModified(a%b, b);
    }

    static int findLCM(int a, int b) {
        return a * b / findGCDEuclidModified(a, b);
    }
}
