package com.company.ArrayPracticeProblems.Part2;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class StocksProblem2 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    // Explanation : Buy at valley (lowest) and sell at peak (highest)
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/discuss/208241/Explanation-for-the-dummy-like-me./477661
    // In above link see newbiecoder1's comment (March 20, 2020 6:34 AM)
    static int maxProfit(int[] prices) {
        int profit = 0;
        int buy = 0;
        int sell = 0;
        int days = prices.length;

        while (buy < days && sell < days) {
            while (buy < days - 1 && prices[buy + 1] < prices[buy]) {
                buy++;
            }

            sell = buy;

            while (sell < days - 1 && prices[sell + 1] > prices[sell]) {
                sell++;
            }

            profit += prices[sell] - prices[buy];

            buy = sell + 1;
        }

        return profit;
    }
}
