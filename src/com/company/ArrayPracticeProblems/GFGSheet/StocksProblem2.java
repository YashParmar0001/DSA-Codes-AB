package com.company.ArrayPracticeProblems.GFGSheet;

import java.util.ArrayList;

public class StocksProblem2 {
    public static void main(String[] args) {
        int[] A = {4, 2, 2, 2, 4};
        System.out.println(stockBuySell(A, A.length));
    }

    static ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int buy = 0, sell = 0;
        int profit;
        while (buy < n && sell < n) {
            while (buy < n-1 && A[buy] > A[buy + 1]) {
                buy++;
            }
            sell = buy;
            while (sell < n-1 && A[sell] < A[sell + 1]) {
                sell++;
            }
            profit = sell - buy;
            if (buy != sell) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(buy); list.add(sell);
                ans.add(list);
            }
            buy = sell + 1;
        }
        return ans;
    }
}
