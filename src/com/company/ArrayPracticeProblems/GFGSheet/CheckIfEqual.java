package com.company.ArrayPracticeProblems.GFGSheet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckIfEqual {
    public static void main(String[] args) {
        long[] A = {3 ,16 ,16 ,13 ,2 ,15 ,19 ,7};
        long[] B = {16 ,3 ,15, 2, 15, 2, 19, 16};
        System.out.println(check(A, B, A.length));
    }

    static boolean check(long A[],long B[],int N) {
        Map<Long, Integer> map = new HashMap<>();
        for (long element : A) {
            if (map.containsKey(element)) {
                int count = map.get(element);
                map.put(element, count+1);
            }else {
                map.put(element, 1);
            }
        }
        for (long element : B) {
            if (!map.containsKey(element)) return false;

            if (map.get(element) == 0) return false;

            int count = map.get(element);
            map.put(element, count-1);
        }

        return true;
    }
}
