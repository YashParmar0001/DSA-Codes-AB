package com.company.ArrayPracticeProblems.Part2;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class StocksProblem1 {
    public static void main(String[] args) {
        int[] prices = {2, 1, 2, 1, 0, 0, 1};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit1(prices));
        System.out.println(maxProfit2(prices));
    }

    // Time : O(n^2)
    static int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                ans = Math.max(prices[j]-prices[i], ans);
            }
        }
        return ans;
    }

    static int maxProfit1(int[] prices) {
        int ans = 0;
        int[] leftMin = new int[prices.length];
        int[] rightMax = new int[prices.length];

        leftMin[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            leftMin[i] = Math.min(leftMin[i-1], prices[i]);
        }

        rightMax[rightMax.length-1] = prices[prices.length-1];
        for (int i = rightMax.length-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], prices[i]);
        }

        for (int i = 0; i < prices.length; i++) {
            ans = Math.max(ans, rightMax[i]-leftMin[i]);
        }

        return ans;
    }

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/1735493/JavaC%2B%2B-best-ever-EXPLANATION-could-possible
    static int maxProfit2(int[] prices) {
        int ans = 0;
        int least_price = Integer.MAX_VALUE;
        int profit = 0;

        for (int price : prices) {
            if (least_price > price) {
                least_price = price;
            }
            profit = price - least_price;

            if (profit > ans) ans = profit;
        }

        return ans;
    }
}
