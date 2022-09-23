package com.company.Graphs.Basics;

import java.util.*;

public class Implementation {
    public static void main(String[] args) {
        int v = 4;
        GraphAdjList graph = new GraphAdjList(v);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        boolean[] visited = new boolean[v];
        GraphAdjList.dfsStack(0, visited);
        System.out.println();
        GraphAdjList.dfs(0, new boolean[v]);
//        System.out.println();
//        visited = new boolean[v];
//        GraphAdjList.bfs(0, visited);
    }
}

class GraphAdjList {
    static List<List<Integer>> list = new ArrayList<>();
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

    public static void dfs(int src, boolean[] visited) {
        visited[src] = true;
        System.out.print(src + ", ");

        for (int neighbour : list.get(src)) {
            if (!visited[neighbour]) {
                dfs(neighbour, visited);
            }
        }
    }

    public static void bfs(int src, boolean[] visited) {
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

    public static void dfsStack(int src, boolean[] visited) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(src);
        visited[src] = true;
        while (!stack.isEmpty()) {
            int current = stack.pop();
            System.out.print(current + ", ");
            for (int neighbour : list.get(current)) {
                if (!visited[neighbour]) {
                    stack.push(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }
}

class GraphAdjMatrix {
    int[][] matrix;
    int v;

    public GraphAdjMatrix(int v) {
        this.v = v;
        matrix = new int[v][v];
    }

    public void addEdge(int src, int dest) {
        matrix[src][dest] = 1;
        matrix[dest][src] = 1; // For undirected graph
    }
}