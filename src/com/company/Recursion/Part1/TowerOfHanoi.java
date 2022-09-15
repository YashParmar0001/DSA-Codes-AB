package com.company.Recursion.Part1;

public class TowerOfHanoi {
    public static void main(String[] args) {
        towerOfHanoi(30, 'A', 'C', 'B');
    }

    static void towerOfHanoi(int n, char from, char to, char aux) {
        if (n == 0) return;

        towerOfHanoi(n-1, from, aux, to);
        System.out.println("Move "+n+" from "+from+" to "+to);
        towerOfHanoi(n-1, aux, to, from);
    }
}
