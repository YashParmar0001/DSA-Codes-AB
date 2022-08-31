package com.company.QueueClass.Problems;

// https://leetcode.com/problems/gas-station/
public class CircularTour_GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = 0; // Initially start from first gas station
        int current = 0;
        int deficit = 0; // for required gas in previous travel

        for (int i = 0; i < n; i++) {
            current += (gas[i] - cost[i]);
            if (current < 0) {
                deficit += current;
                current = 0;
                start = i + 1;
            }
        }
        if ((current + deficit) >= 0) return start;
        else return -1;
    }
}
