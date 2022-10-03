package com.company;

import java.util.*;

public class GFGStreak {
    public static void main(String[] args) {
        int l = 1, r = 6;
        System.out.println(sumOfAll(l, r));
    }

    static int sumOfAll(int l, int r) {
        int totalSum = 0;
        if (l == 1) {
            totalSum += 1;
            l++;
        }
        for (int x = l ; x <= r; x++){
            int sum = 0;
            boolean[] isPrime = new boolean[x+1];
            Arrays.fill(isPrime, true);

            for (int i = 2; i * i <= x; i++) {
                if(isPrime[i]) {
                    if (x % i == 0) sum += i;
                    for (int j = i * i; j <= x; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
            for (int i = 2; i < isPrime.length; i++) {
                if (isPrime[i]&& x%i == 0) sum += i ;
            }
            totalSum += sum;
        }
        return totalSum;
    }
}
