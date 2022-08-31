package com.company.Hashing.Basics;

import java.util.Arrays;

public class LargestSubstringDistinct {
    public static void main(String[] args) {
        String s = "abcdcapbbbc";
        System.out.println(largest(s));
    }

    // Explanation : 01:06:00
    static int largest(String s) {
        int[] index = new int[256];
        int i = 0, j = 0;
        Arrays.fill(index, -1);
        int ans = 0;

        while (j < s.length()) {
            int lastPos = index[s.charAt(j)];
            boolean isPresent = true;
//            boolean isPresent = lastPos != -1 && lastPos >= i;
            if (lastPos == -1 || lastPos < i) {
                isPresent = false;
            }
            if (isPresent) {
                i = lastPos + 1;
            }
            int currWindowSize = j - i + 1;
            ans = Math.max(ans, currWindowSize);
            index[s.charAt(j)] = j;
            j++;
        }
        return ans;
    }
}
