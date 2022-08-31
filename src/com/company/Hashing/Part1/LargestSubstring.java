package com.company.Hashing.Part1;

import java.util.Arrays;

public class LargestSubstring {
    public static void main(String[] args) {
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
    }

    static int lengthOfLongestSubstring(String s) {
        int[] index = new int[256];
        Arrays.fill(index, -1);
        int i = 0, j = 0;
        int ans = 0;
        index[s.charAt(i)] = 0;
        while (j < s.length() - 1) {
            if (index[s.charAt(j+1)] == -1) { // If element is not visited before than j++
            }else {
                if (i <= index[s.charAt(j + 1)]) {
                    i = index[s.charAt(j + 1)] + 1;
                }
            }
            index[s.charAt(j+1)] = j + 1;
            j++;
            ans = Math.max(ans, j-i+1);
        }
//        ans = Math.max(ans, j-i+1);
        return ans;
    }
}
