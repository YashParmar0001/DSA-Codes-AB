package com.company.Graphs.Part3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class ShortestPathInDAG {
    public static void main(String[] args) {
        int v = 5;
        Graph graph = new Graph(v);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 4, 7);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 4, 4);
        graph.addEdge(2, 3, 2);
        graph.addEdge(3, 4, 2);
        System.out.println(Arrays.toString(shortestPath(v, graph.adj, 0)));
    }

    static int[] shortestPath(int v, ArrayList<ArrayList<Pair>> adj, int src) {
        ArrayDeque<Integer> stack = topoSort(v, adj);
        int[] distance = new int[v];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        while (!stack.isEmpty()) {
            int current = stack.pop();
            for (Pair neighbour : adj.get(current)) {
                if (distance[neighbour.value] > distance[current] + neighbour.weight) {
                    distance[neighbour.value] = distance[current] + neighbour.weight;
                }
            }
        }

        return distance;
    }

    static ArrayDeque<Integer> topoSort(int v, ArrayList<ArrayList<Pair>> adj) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) dfs(i, visited, adj, stack);
        }
        return stack;
    }

    static void dfs(int src, boolean[] visited, ArrayList<ArrayList<Pair>> adj, ArrayDeque<Integer> stack) {
        visited[src] = true;
        for (Pair neighbour : adj.get(src)) {
            if (!visited[neighbour.value]) {
                dfs(neighbour.value, visited, adj, stack);
            }
        }
        stack.push(src);
    }
}

class Pair {
    int value;
    int weight;
    public Pair(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

class Graph {
    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    int v;

    public Graph(int v) {
        this.v = v;
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest, int weight) {
        adj.get(src).add(new Pair(dest, weight));
    }

    public void addUDEdge(int src, int dest, int weight) {
        adj.get(src).add(new Pair(dest, weight));
        adj.get(dest).add(new Pair(src, weight));
    }
}