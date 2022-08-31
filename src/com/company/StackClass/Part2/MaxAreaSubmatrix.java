package com.company.StackClass.Part2;

import java.util.ArrayDeque;

// https://leetcode.com/problems/maximal-rectangle/
public class MaxAreaSubmatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 0, 1},
                          {1, 1, 0, 1},
                          {1, 0, 0, 1},
                          {1, 1, 0, 0}};
        char[][] matrix1 = {{'1', '1', '0', '1'},{'1', '1', '0', '1'},{'1','0','0','1'},{'1','1','0','0'}};
        System.out.println(maximalRectangle(matrix1));
        System.out.println(maxArea(matrix));
    }

    static int maxArea(int[][] matrix) {
        int[] base = new int[matrix[0].length];
        int max = 0;
        for (int[] rows : matrix) {
            for (int j = 0; j < base.length; j++) {
                if (rows[j] == 0) {
                    base[j] = 0;
                } else {
                    base[j]++;
                }
            }
            int current = largestRectangleArea(base);
            max = Math.max(max, current);
        }
        return max;
    }

    static int maximalRectangle(char[][] matrix) {
        int[] base = new int[matrix[0].length];
        int max = 0;
        for (char[] rows : matrix) {
            for (int j = 0; j < base.length; j++) {
                if (rows[j] - '0' == 0) {
                    base[j] = 0;
                } else {
                    base[j]++;
                }
            }
            int current = largestRectangleArea(base);
            max = Math.max(max, current);
        }
        return max;
    }

    static int largestRectangleArea(int[] heights) {
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
