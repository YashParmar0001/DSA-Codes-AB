package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class GFGStreak {
    public static void main(String[] args) {
        int[] arr = {1, 6, 2};
        System.out.println(leftSmaller(arr.length, arr));
    }

    static List<Integer> leftSmaller(int n, int arr[]) {
        List<Integer> ans = new ArrayList<>(n);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int e : arr) {
            while (!stack.isEmpty() && stack.peek() >= e) {
                stack.pop();
            }
            if (stack.isEmpty()) ans.add(-1);
            else ans.add(stack.peek());

            stack.push(e);
        }
        return ans;
    }
}
