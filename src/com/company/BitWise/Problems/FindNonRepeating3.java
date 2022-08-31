package com.company.BitWise.Problems;

import java.util.Arrays;

public class FindNonRepeating3 {
    public static void main(String[] args) {
//        int[] arr = {3, 3, 1, 2, 2, 3, 2};
        int[] arr2 = {-3, -4, 1, -3, -3, 1, 1, 2, 2, 2};
        System.out.println(singleElement(arr2, arr2.length));
//        int a = -3;
//        System.out.println(Integer.toBinaryString(a));
//        a >>= 1;
//        a >>= 5;
//        System.out.println(a);
//        System.out.println(Integer.toBinaryString(a));
//        System.out.println(Integer.toBinaryString(3));
    }

    static int singleElement(int[] arr , int N) {
        int[] bits = new int[32];
        for (int n : arr) {
            int index = 0;
            if (n < 0) {
                while (n != -1) {
                    bits[index] += n & 1;
                    index++;
                    n >>= 1;
                    System.out.println(n + " = " + Arrays.toString(bits));
                }
            }else {
                while (n != 0) {
                    bits[index] += n & 1;
                    index++;
                    n >>= 1;
                }
            }
        }
        System.out.println(Arrays.toString(bits));
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] % 3 == 0) bits[i] = 0;
            else bits[i] = 1;
        }
        return convertBinary(bits);
    }

    static int convertBinary(int[] bits) {
        int ans = 0;
        int power = 0;
        for (int bit : bits) {
            ans += bit * Math.pow(2, power);
            power++;
        }
        return ans;
    }
}
