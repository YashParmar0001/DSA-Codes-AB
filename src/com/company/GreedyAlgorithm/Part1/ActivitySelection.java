package com.company.GreedyAlgorithm.Part1;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static void main(String[] args) {
        int n = 4;
        int[] start = {1, 3, 2, 5};
        int[] end = {2, 4, 3, 6};
        System.out.println(activitySelection(start, end, n));
    }

    public static int activitySelection(int[] start, int[] end, int n) {
        if (n == 0) return 0;
        Pair[] activity = new Pair[n];
        for (int i = 0; i < n; i++) {
            activity[i] = new Pair(start[i], end[i]);
        }
        Arrays.sort(activity, Comparator.comparingInt(a -> a.end));

        int currEnd = activity[0].end;
        int ans = 1;

        for (int i = 1; i < n; i++) {
            if (activity[i].start > currEnd) {
                ans++;
                currEnd = activity[i].end;
            }
        }
        return ans;
    }

    static class Pair {
        int start, end;
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
