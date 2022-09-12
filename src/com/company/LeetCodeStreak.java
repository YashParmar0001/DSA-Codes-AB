package com.company;

import java.util.Arrays;

public class LeetCodeStreak {
    public static void main(String[] args) {
        int[] tokens = {26};
        int power = 51;
        System.out.println(bagOfTokensScore(tokens, power));

    }

    static int bagOfTokensScore(int[] tokens, int power) {
        if (tokens.length == 0) return 0;
        if (tokens.length == 1) {
            if (power >= tokens[0]) {
                return 1;
            }else return 0;
        }
        int score = 0;
        Arrays.sort(tokens);
        int left = 0, right = tokens.length-1;

        while (left <= right) {
            if (tokens[left] <= power) {
                power -= tokens[left];
                score++;
                left++;
            }else if (score >= 1 && tokens[right] >= power) {
                if (left == right) {
                    return score;
                }
                power += tokens[right];
                score--;
                right--;
            }else return score;
        }
        return score;
    }
}