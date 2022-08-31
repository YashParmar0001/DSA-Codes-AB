package com.company.BinarySearch.Part2;

public class WoodCutterProblem {
    public static void main(String[] args) {
        int[] trees = {6, 5, 10, 9, 2, 4, 9, 5};
        System.out.println(heightOfCutter(trees, 10));
    }

    static int heightOfCutter(int[] trees, int k) {
        int left = 0, right = -1;
        for (int tree : trees) {
            right = Math.max(tree, right);
        }

        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (isEnough(trees, k, mid)) {
                ans = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return ans;
    }

    static boolean isEnough(int[] trees, int k, int height) {
        int total = 0;
        for (int tree : trees) {
            if (height < tree) {
                total += tree - height;
            }
        }
        return total >= k;
    }
}
