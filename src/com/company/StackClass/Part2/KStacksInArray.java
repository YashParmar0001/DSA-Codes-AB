package com.company.StackClass.Part2;

import java.util.Arrays;

// https://www.codingninjas.com/codestudio/problems/n-stacks-in-an-array_1164271?leftPanelTab=1
public class KStacksInArray {
    public static void main(String[] args) throws Exception {
        KStacks stacks = new KStacks(8, 3);
        stacks.push(1, 0);
        stacks.push(2, 0);
        stacks.push(4, 1);
        stacks.push(5, 1);
        stacks.push(10, 2);
        stacks.push(11, 2);
        System.out.println(stacks.pop(0));
        System.out.println(stacks.pop(0));
        System.out.println(stacks.pop(1));
        System.out.println(stacks.pop(2));
    }
}

class KStacks {
    int[] arr;
    int[] next;
    int[] top;
    int k;
    int free;

    public KStacks(int size, int k) {
        this.k = k;
        arr = new int[size];
        next = new int[size];
        top = new int[k];
        free = 0;

        Arrays.fill(top, -1);

        for (int i = 0; i < next.length-1; i++) {
            next[i] = i + 1;
        }
        next[next.length-1] = -1;
    }

    void push(int data, int sn) throws Exception {
        if (isFull()) throw new Exception("Stack array is full!");
        int i = free;
        arr[i] = data;
        free = next[i];
        next[i] = top[sn];
        top[sn] = i;
    }

    int pop(int sn) throws Exception {
        if (isEmpty(sn)) throw new Exception("Stack is empty!");
        int i = top[sn];
        top[sn] = next[i];
        next[i] = free;
        free = i;
        return arr[i];
    }

    boolean isFull() {
        return free == -1;
    }

    boolean isEmpty(int sn) {
        return top[sn] == -1;
    }
}
