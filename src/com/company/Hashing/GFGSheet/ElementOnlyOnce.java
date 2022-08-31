package com.company.Hashing.GFGSheet;

public class ElementOnlyOnce {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 50, 50, 65, 65};
        System.out.println(findOnce(arr, arr.length));
    }

    static int findOnce(int arr[], int n)
    {
        int xor = 0;
        for (int num : arr) {
            xor ^= num;
        }
        return xor;
    }
}
