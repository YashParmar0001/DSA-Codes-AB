package com.company.ArrayPracticeProblems.GFGSheet;

import java.util.Arrays;

public class SwappingPairs {
    public static void main(String[] args) {
        long[] A = {4, 1, 2, 1, 1, 2};
        long[] B = {3, 6, 3, 3};
        System.out.println(findSwapValues(A, A.length, B, B.length));
        System.out.println(Arrays.toString(findSwapValues1(A, A.length, B, B.length)));
    }

    static long findSwapValues(long A[], int n, long  B[], int m) {
        if (n > m) findSwapValues(B, m, A, n);
        Arrays.sort(A); Arrays.sort(B);
        int sumA = 0, sumB = 0;
        for (long element : A) sumA += element;
        for (long element : B) sumB += element;
        for (long element : A) {
            int start = 0, end = m-1;
            int mid;
            long dif;
            while (start < end) {
                int tempSumA = sumA;
                int tempSumB = sumB;
                mid = start + (end - start)/2;
                if (element > B[mid]) {
                    dif = element - B[mid];
                    tempSumA -= dif;
                    tempSumB += dif;
                }else {
                    dif = B[mid] - element;
                    tempSumA += dif;
                    tempSumB -= dif;
                }
                if (tempSumA == tempSumB) return 1;
                else if (tempSumA > tempSumB) {
                    end = mid;
                }else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    static long[] findSwapValues1(long A[], int n, long  B[], int m) {
        if (n > m) findSwapValues1(B, m, A, n);
        Arrays.sort(A); Arrays.sort(B);
        int sumA = 0, sumB = 0;
        for (long element : A) sumA += element;
        for (long element : B) sumB += element;
        for (long element : A) {
            int start = 0, end = m-1;
            int mid;
            long dif;
            while (start < end) {
                int tempSumA = sumA;
                int tempSumB = sumB;
                mid = start + (end - start)/2;
                if (element > B[mid]) {
                    dif = element - B[mid];
                    tempSumA -= dif;
                    tempSumB += dif;
                }else {
                    dif = B[mid] - element;
                    tempSumA += dif;
                    tempSumB -= dif;
                }
                if (tempSumA == tempSumB) return new long[]{element, B[mid]};
                else if (tempSumA > tempSumB) {
                    end = mid;
                }else {
                    start = mid + 1;
                }
            }
        }
        return new long[]{-1};
    }
}
