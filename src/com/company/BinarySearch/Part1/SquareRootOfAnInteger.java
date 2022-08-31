package com.company.BinarySearch.Part1;

public class SquareRootOfAnInteger {
    public static void main(String[] args) {
        System.out.println(sqrRoot(2147395599));
    }

    static int sqrRoot(int n) {

        if (n == 0) return 0;

        int left = 1;
        int right = n;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
//            if (mid * mid == n) return mid;
            if (mid == n / mid) return mid;
//            else if (mid * mid < n) left = mid + 1;
            else if (mid < n / mid) left = mid + 1;
            else right = mid - 1;
        }

        return right;
    }
}