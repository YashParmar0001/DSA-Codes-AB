package com.company.Graphs.Part1;

import java.util.*;

public class NumberOfDisconnected {
    public static void main(String[] args) {
        int v = 8;
        GraphAdjList graph = new GraphAdjList(v);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);

        graph.addEdge(4, 6);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);

        boolean[] visited = new boolean[v];
        System.out.println(numberOfDisconnected(graph.list, visited, v));
    }

    static int numberOfDisconnected(List<List<Integer>> list, boolean[] visited, int v) {
        int count = 0;
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                count++;
                GraphAdjList.dfs(list, i, visited);
            }
        }
        System.out.println();
        return count;
    }
}

class GraphAdjList {
    List<List<Integer>> list = new ArrayList<>();
    int v;

    public GraphAdjList(int v) {
        this.v = v;
        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        list.get(src).add(dest);
        list.get(dest).add(src);
    }

    public static void dfs(List<List<Integer>> list, int src, boolean[] visited) {
        visited[src] = true;
        System.out.print(src + ", ");

        for (int neighbour : list.get(src)) {
            if (!visited[neighbour]) {
                dfs(list, neighbour, visited);
            }
        }
    }

    public static void bfs(List<List<Integer>> list, int src, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        visited[src] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + ", ");
            for (int neighbour : list.get(current)) {
                if (!visited[neighbour]) {
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }
}
