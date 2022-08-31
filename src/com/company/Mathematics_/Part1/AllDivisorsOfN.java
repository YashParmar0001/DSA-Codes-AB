package com.company.Mathematics_.Part1;

public class AllDivisorsOfN {
    public static void main(String[] args) {
//        printDivisors1(30);
        printSortedDivisors(30);
    }

    // Time : O(n)
    static void printDivisors(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) System.out.print(i + ", ");
        }
    }

    // Time : O(root N)
    static void printDivisors1(int n) {
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + ", ");
                // To avoid duplicates
                if (n / i != i) System.out.print(n/i + ", ");
            }
        }
    }

    static void printSortedDivisors(int n) {
        int i = 1;
        for (; i * i <= n; i++) {
            if (n % i == 0) System.out.print(i + ", ");
        }
        i--;
        for (; i >= 1; i--) {
            if (n % i == 0) {
                if (n / i != i) System.out.print(n/i + ", ");
            }
        }
    }
}
