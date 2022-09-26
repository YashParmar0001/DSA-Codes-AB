package com.company.Graphs.Part2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class DetectACycleInDirected {
    public static void main(String[] args) {

    }

    static boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = indegree(v, adj);
        int count = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                count++;
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbour : adj.get(current)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    queue.offer(neighbour);
                    count++;
                }
            }
        }
        return count < v;
    }

    static int[] indegree(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int neighbour : adj.get(i)) {
                inDegree[neighbour]++;
            }
        }
        return inDegree;
    }
}
