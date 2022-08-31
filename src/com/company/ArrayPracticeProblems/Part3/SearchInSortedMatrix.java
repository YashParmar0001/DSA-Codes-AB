package com.company.ArrayPracticeProblems.Part3;

import java.util.Arrays;

public class SearchInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 5, 7},
                          {2, 5, 6, 9},
                          {6, 10, 11, 13}};
        System.out.println(Arrays.toString(search(matrix, 6)));
    }

    static int[] search(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return new int[]{i, j};
            }else if (matrix[i][j] < target) {
                i++;
            }else j--;
        }
        return new int[]{-1, -1};
    }
}
