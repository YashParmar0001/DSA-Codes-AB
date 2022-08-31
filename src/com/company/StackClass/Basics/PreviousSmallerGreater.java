package com.company.StackClass.Basics;

import java.util.ArrayDeque;
import java.util.Arrays;

public class PreviousSmallerGreater {
    public static void main(String[] args) {
        int[] arr = {10, 4, 2, 20, 40, 12, 30};
        System.out.println(Arrays.toString(previousSmaller(arr)));
        System.out.println(Arrays.toString(previousGreater(arr)));
    }

    static int[] previousSmaller(int[] arr) {
        int[] ans = new int[arr.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        for (int element : arr) {
            while (!stack.isEmpty() && stack.peek() >= element) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[index] = -1;
            }else {
                ans[index] = stack.peek();
            }
            stack.push(element);
            index++;
        }
        return ans;
    }

    static int[] previousGreater(int[] arr) {
        int[] ans = new int[arr.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        for (int element : arr) {
            while (!stack.isEmpty() && stack.peek() <= element) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[index] = -1;
            }else {
                ans[index] = stack.peek();
            }
            stack.push(element);
            index++;
        }
        return ans;
    }
}
