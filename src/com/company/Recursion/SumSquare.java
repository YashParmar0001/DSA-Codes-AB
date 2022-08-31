package com.company.Recursion;

public class SumSquare {
    public static void main(String[] args) {
        System.out.println(sum(5));
    }

    static int sum(int n){
        if (n == 1) return 1;

        int sum = n * n;

        return sum + sum(n - 1);
    }
}
