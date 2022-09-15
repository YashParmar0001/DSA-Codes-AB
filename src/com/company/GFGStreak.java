package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GFGStreak {
    public static void main(String[] args) {
        ArrayList<Long> list = new ArrayList<>();
        list.add(3L); list.add(5L); list.add(7L);
        System.out.println(numberOfSubsequences(list.size(), list));
    }

    static Set<Long> set = new HashSet<>();
    static ArrayList<Long> ansList = new ArrayList<>();

    static Long numberOfSubsequences(int N, ArrayList<Long> A){
        long ans = 0;
        subseq(A, 0, 1);
        for (long e : ansList) {
            double d = Math.log10(e)/Math.log10(2);
            if (d == (long)d) ans++;
        }
        return ans-1;
    }

    static void subseq(ArrayList<Long> list, int i, long value) {
        if (i == list.size()) {
            ansList.add(value);
            return;
        }

        double d = Math.log10(value) / Math.log10(2);
        if (d != (long) d) return;

        subseq(list, i+1, value * list.get(i));
        subseq(list, i+1, value);
    }
}
