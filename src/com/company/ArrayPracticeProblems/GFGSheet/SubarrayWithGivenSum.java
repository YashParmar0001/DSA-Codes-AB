package com.company.ArrayPracticeProblems.GFGSheet;

import java.util.ArrayList;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(subarraySum(arr, arr.length, 0));
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        int start = 0, end = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        int currentSum = 0;
        while (start < n || end < n) {
            while (end < n && currentSum < s) {
                currentSum += arr[end];
                end++;
            }
            if (currentSum == s) {
                ans.add(start + 1); ans.add(end);
                return ans;
            }
            currentSum -= arr[start];
            start++;
        }
        ans.add(-1);
        return ans;
    }
}
