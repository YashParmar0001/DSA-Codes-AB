package com.company.Graphs.Part1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPath {
    public static void main(String[] args) {
        int v = 6;
        GraphAdjList graph = new GraphAdjList(v);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 4);
        graph.addEdge(1, 3);
        graph.addEdge(3, 5);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        boolean[] visited = new boolean[v];
        int[] distance = new int[v];
        Arrays.fill(distance, Integer.MAX_VALUE);
        shortestPath(graph.list, 0, visited, distance);
        System.out.println();
        for (int i = 0; i < v; i++) {
            System.out.println(i + " --> " + distance[i]);
        }
    }

    static void shortestPath(List<List<Integer>> list, int src, boolean[] visited, int[] distance) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        visited[src] = true;
        distance[src] = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + ", ");
            for (int neighbour : list.get(current)) {
                if (!visited[neighbour]) {
                    distance[neighbour] = distance[current] + 1;
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }
}