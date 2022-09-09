package com.company;

import java.util.Arrays;

public class Streak {
    public static void main(String[] args) {
        int[][] properties = {{2,2}, {3,3}};
        System.out.println(numberOfWeakCharacters(properties));
    }

    static int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> (b[0] == a[0]) ? (a[1] - b[1]) : b[0] - a[0]);
//        Arrays.sort(properties, (a, b) -> b[1]-a[1]);
        int ans = 0;
        int max = 0;
        for (int[] row : properties) System.out.println(Arrays.toString(row));
        for (int[] property : properties) {
            if (property[1] < max) {
                ans++;
            }
            max = Math.max(max, property[1]);
        }
        return ans;
    }
}
