package com.company;

import java.util.Arrays;

public class LeetCodeStreak {
    public static void main(String[] args) {
        System.out.println(validUtf8(new int[]{10}));
    }

    static boolean validUtf8(int[] data) {
        return util(data, 0);
    }

    static boolean util(int[] data, int index) {
        if (index >= data.length) return true;

        int mask = 1;
        mask <<= 7;
        int count = 0;
        int i = 0;
//        if ((data[index] & mask) == 0) return true;
        while (i < 5) {
            if ((data[index] & mask) == mask) {
                count++;
            }else if ((data[index] & mask) == 0) break;
            mask >>= 1;
            i++;
        }
        if (count == 0) return util(data, index+1);
        if (count == 1) return false;
        if (count > 4) return false;
        if (data.length-index < count) return false;
        int j;
        for (j = index+1; j < index+count; j++) {
            if ((data[j] & 128) != 128) return false;
        }
        return util(data, j);
    }
}