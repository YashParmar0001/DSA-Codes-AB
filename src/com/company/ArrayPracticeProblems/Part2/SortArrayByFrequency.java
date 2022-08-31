package com.company.ArrayPracticeProblems.Part2;

import java.util.Arrays;

public class SortArrayByFrequency {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 3, 4, 4, 4, 4};
        System.out.println(Arrays.toString(frequencySort(nums)));
    }

    static int[] frequencySort(int[] nums) {
        // Making a new array for storing values
        int[][] map = new int[nums.length][2];
        // Adding first element
        map[0][0] = nums[0]; map[0][1] = 1;
        int index = 1;
        int key_index = 0;
        // creating map --> (element, frequency)
        while (index < nums.length) {
            if (nums[index] != nums[index - 1]) {
                key_index++;
                map[key_index][0] = nums[index];
                map[key_index][1] = 1;
            }else {
                map[key_index][1]++;
            }
            index++;
        }

        // sorting map by frequency
        sort(map);

        // creating answer array using map
        int[] ans = new int[nums.length];
        int index_ = 0;

        for (int[] ints : map) {
            for (int j = 0; j < ints[1]; j++) {
                ans[index_] = ints[0];
                index_++;
            }
        }

        for (int[] row : map) {
            System.out.println(Arrays.toString(row));
        }

        return ans;
    }

    static void sort(int[][] map) {
        for (int i = 0; i < map.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (map[j][1] < map[j-1][1]) {
                    int[] temp = map[j];
                    map[j] = map[j-1];
                    map[j-1] = temp;
                }else break;
            }
        }
    }
}
