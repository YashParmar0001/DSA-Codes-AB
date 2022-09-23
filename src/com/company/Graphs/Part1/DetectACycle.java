package com.company.Graphs.Part1;

import java.util.ArrayList;
import java.util.List;

public class DetectACycle {
    public static void main(String[] args) {
        GraphAdjList graph = new GraphAdjList(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
//        graph.addEdge(5, 2);
        graph.addEdge(0, 4);
        System.out.println(isCycle(6, graph.list));
    }

    static boolean isCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        return detect(adj, 0, visited, -1);
    }

    static boolean detect(List<List<Integer>> list, int src, boolean[] visited, int parent) {
        visited[src] = true;

        for (int neighbour : list.get(src)) {
            if (!visited[neighbour]) {
                return detect(list, neighbour, visited, src);
            }else if (neighbour != parent) {
                return true;
            }
        }
        return false;
    }
}
