package com.company.GreedyAlgorithm.Part2;

import java.util.Arrays;

public class MinimumPlatforms {
    public static void main(String[] args) {

    }

    static int findPlatform(int[] arr, int[] dep, int n) {
        Arrays.sort(arr); Arrays.sort(dep);
        int count = 0;
        int i = 0, j = 0;
        int ans = 0;
        while (i < n) {
            if (arr[i] <= dep[j]) {
                count++;
                i++;
                ans = Math.max(ans, count);
            }else {
                count--;
                j++;
            }
        }
        return ans;
    }
}
