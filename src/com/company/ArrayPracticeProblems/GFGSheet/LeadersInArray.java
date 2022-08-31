package com.company.ArrayPracticeProblems.GFGSheet;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,0};
        ArrayList<Integer> ans = leaders(arr, arr.length);
        System.out.println(ans);
    }

    static ArrayList<Integer> leaders(int arr[], int n){
        ArrayList<Integer> ans = new ArrayList<>();
        int leader = arr[n-1];
        ans.add(leader);
        int i = n-2;
        while (i >= 0) {
            if (leader < arr[i]) {
                leader = arr[i];
                ans.add(leader);
            }
            i--;
        }
        Collections.reverse(ans);
        return ans;
    }
}
