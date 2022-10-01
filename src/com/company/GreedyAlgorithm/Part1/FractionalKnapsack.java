package com.company.GreedyAlgorithm.Part1;

import java.util.Arrays;

public class FractionalKnapsack {
    public static void main(String[] args) {

    }

    double fractionalKnapsack(int W, Item[] arr, int n) {
        Arrays.sort(arr, (i1, i2) -> i1.weight*i2.value - i2.weight*i1.value);
        double ans = 0;
        for (int i = 0; i < n; i++) {
            if (W >= arr[i].weight) {
                ans += arr[i].value;
                W -= arr[i].weight;
            }else {
                ans += arr[i].value * W / (double) arr[i].weight;
            }
        }
        return ans;
    }

    static class Item {
        int value, weight;
        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }
}
