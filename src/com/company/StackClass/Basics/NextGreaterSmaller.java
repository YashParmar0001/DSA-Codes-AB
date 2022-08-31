package com.company.StackClass.Basics;

import java.util.ArrayDeque;
import java.util.Arrays;

public class NextGreaterSmaller {
    public static void main(String[] args) {
        int[] arr = {3, 8, 5, 2, 25};
        System.out.println(Arrays.toString(help_classmate(arr, arr.length)));
    }

    static long[] nextLargerElement(long[] arr, int n) {
        long[] ans = new long[n];
        int index = ans.length-1;
        ArrayDeque<Long> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            long element = arr[i];
            while (!stack.isEmpty() && stack.peek() <= element) {
                stack.pop();
            }
            if (stack.isEmpty()) ans[index] = -1;
            else ans[index] = stack.peek();
            stack.push(element);
            index--;
        }
        return ans;
    }

    // Next smaller element
    static int[] help_classmate(int arr[], int n) {
        int[] ans = new int[n];
        int index = n - 1;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            int element = arr[i];
            while (!stack.isEmpty() && stack.peek() >= element) {
                stack.pop();
            }
            if (stack.isEmpty()) ans[index] = -1;
            else ans[index] = stack.peek();
            stack.push(element);
            index--;
        }
        return ans;
    }
}
