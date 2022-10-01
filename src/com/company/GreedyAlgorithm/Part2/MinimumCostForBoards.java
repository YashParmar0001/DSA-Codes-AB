package com.company.GreedyAlgorithm.Part2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MinimumCostForBoards {
    public static void main(String[] args) {

    }

    public static int minimumCostOfBreaking(int[] x, int[] y,int m,int n) {
        Arrays.sort(x);
        Arrays.sort(y);
        int i = m-1;
        int j = n-1;
        int h = 1, v = 1;
        int ans = 0;
        while (i >= 0 && j >= 0) {
            if (x[i] >= y[j]) {
                ans += x[i] * h;
                v++;
                i--;
            }else {
                ans += y[j] * v;
                h++;
                j--;
            }
        }

        while (i >= 0) {
            ans += x[i] * h;
            i--;
        }

        while (j >= 0) {
            ans += y[j] * v;
            j--;
        }

        return ans;
    }
}
