package com.company.Graphs.Part1;

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

    static Boolean isCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (detect(adj, i, visited, -1)) return true;
            }
        }
        return false;
    }

    static Boolean detect(List<List<Integer>> list, int src, boolean[] visited, int parent) {
        visited[src] = true;

        for (Integer neighbour : list.get(src)) {
            if (!visited[neighbour]) {
                if (detect(list, neighbour, visited, src)) return true;
            }else if (neighbour != parent) {
                return true;
            }
        }
        return false;
    }
}
