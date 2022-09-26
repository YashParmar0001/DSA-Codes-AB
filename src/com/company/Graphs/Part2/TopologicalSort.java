package com.company.Graphs.Part2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class TopologicalSort {
    public static void main(String[] args) {
        int v = 6;
        Graph graph = new Graph(v);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        System.out.println(Arrays.toString(topoSort1(v, graph.adj)));
        System.out.println(Arrays.toString(topoSort(v, graph.adj)));
    }

    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) dfs(i, visited, adj, stack);
        }

        int[] ans = new int[v]; int index = 0;
        while (!stack.isEmpty()) {
            ans[index] = stack.pop();
            index++;
        }
        return ans;
    }

    static int[] topoSort1(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = indegree(v, adj);
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        int[] ans = new int[v]; int index = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            ans[index] = current; index++;
            for (int neighbour : adj.get(current)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }
        return ans;
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

    static void dfs(int src, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayDeque<Integer> stack) {
        visited[src] = true;

        for (int neighbour : adj.get(src)) {
            if (!visited[neighbour]) {
                dfs(neighbour, visited, adj, stack);
            }
        }

        stack.push(src);
    }
}

class Graph {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    int v;

    public Graph(int v) {
        this.v = v;
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        adj.get(src).add(dest);
    }
}