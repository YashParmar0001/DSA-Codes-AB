package com.company.Graphs.Part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IndegreeOfGraph {
    public static void main(String[] args) {
        GraphAdjList graph = new GraphAdjList(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        System.out.println(Arrays.toString(graph.indegree()));
    }
}

// This is a directed graph
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
    }

    public int[] indegree() {
        int[] inDegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int neighbour : list.get(i)) {
                inDegree[neighbour]++;
            }
        }
        return inDegree;
    }
}
