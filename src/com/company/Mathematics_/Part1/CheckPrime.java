package com.company.Mathematics_.Part1;

public class CheckPrime {
    public static void main(String[] args) {
        System.out.println(isPrimeEfficient(911));
    }

    // Time : O(root N)
    static boolean isPrime(int n) {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Time : O(root N)
    // 3 times faster than previous one
    static boolean isPrimeEfficient(int n) {
        if (n == 1) return false;

        if (n == 2 || n == 3) return true;

        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}
