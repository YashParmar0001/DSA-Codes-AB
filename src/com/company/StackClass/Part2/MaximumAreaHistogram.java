package com.company.StackClass.Part2;

import java.util.ArrayDeque;

// https://leetcode.com/problems/largest-rectangle-in-histogram/
public class MaximumAreaHistogram {
    public static void main(String[] args) {
        int[] heights = {4, 2, 1, 4, 3, 0, 2, 3};
        System.out.println(largestRectangleArea(heights));
        System.out.println(largestRectangleArea1(heights));
    }

    // Time : O(n^2)
    static int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i, right = i;
            while (left >= 0 && heights[left] >= heights[i]) left--;
            while (right < heights.length && heights[right] >= heights[i]) right++;
            int width = right - left - 1;
            int currentArea = heights[i] * width;
            max = Math.max(currentArea, max);
        }
        return max;
    }

    // Time : O(n), Space : O(n)
    static int largestRectangleArea1(int[] heights) {
        int[] ps = previousSmaller(heights);
        int[] ns = nextSmaller(heights);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = ns[i] - ps[i] - 1;
            int currentArea = heights[i] * width;
            max = Math.max(currentArea, max);
        }
        return max;
    }

    // Array for storing indices of previous smaller elements
    static int[] previousSmaller(int[] arr) {
        int[] ans = new int[arr.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] >= element) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[index] = -1;
            }else {
                ans[index] = stack.peek();
            }
            stack.push(i);
            index++;
        }
        return ans;
    }

    // Array for storing indices of next smaller elements
    static int[] nextSmaller(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int index = n - 1;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            int element = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] >= element) {
                stack.pop();
            }
            if (stack.isEmpty()) ans[index] = n;
            else ans[index] = stack.peek();
            stack.push(i);
            index--;
        }
        return ans;
    }
}
