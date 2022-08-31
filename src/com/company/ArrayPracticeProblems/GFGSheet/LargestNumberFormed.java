package com.company.ArrayPracticeProblems.GFGSheet;

import java.util.Arrays;

public class LargestNumberFormed {
    public static void main(String[] args) {
        String[] arr = {"3", "30", "34", "5", "9"};
        System.out.println(printLargest(arr));
    }

    static String printLargest(String[] arr) {
        Arrays.sort(arr, (a, b) -> {
            String ab = a + b;
            String ba = b + a;
            // returning -1 because we want to sort array elements in descending order
            return ab.compareTo(ba) > 0 ? -1 : 1;
        });

        StringBuilder ans = new StringBuilder();
        for (String num : arr) {
            ans.append(num);
        }
        return ans.toString();
    }
}
