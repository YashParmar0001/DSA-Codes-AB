package com.company.Graphs.Part3;

import java.util.ArrayList;
import java.util.Comparator;

public class KruskalMST {
    public static void main(String[] args) {
        int v = 5;
        GraphKruskal graph = new GraphKruskal(v);
        graph.addEdge(0, 1, 7);
        graph.addEdge(0, 2, 8);
        graph.addEdge(0, 3, 3);
        graph.addEdge(1, 3, 1);
        graph.addEdge(1, 4, 2);
        graph.addEdge(2, 3, 1);
        graph.addEdge(2, 1, 2);
        graph.addEdge(3, 4, 5);
        System.out.println(spanningTree(v, graph.adj));
    }

    // Parent and Rank array for Disjoint set
    static int[] parent, rank;

    // Union find with rank
    static void union(int a, int b) {
        int captainA = find(a);
        int captainB = find(b);

        if (captainA == captainB) return;

        if (rank[captainA] > rank[captainB]) {
            parent[captainB] = captainA;
        }else if (rank[captainA] < rank[captainB]) {
            parent[captainA] = captainB;
        }else {
            parent[captainB] = captainA;
            rank[captainA]++;
        }
    }

    // To find captain
    static int find(int a) {
        // Using path compression
        if (a != parent[a]) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }

    static int spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        boolean[][] added = new boolean[v][v]; // To keep track of already inserted edges
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                ArrayList<Integer> curEdge = adj.get(i).get(j);
                if (!added[i][curEdge.get(0)]) {
                    added[i][curEdge.get(0)] = true;
                    added[curEdge.get(0)][i] = true;
                    edges.add(new Edge(i, curEdge.get(0), curEdge.get(1)));
                }
            }
        }

        // Initializing parent array
        parent = new int[v];
        rank = new int[v];
        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }

        // Sort the edges by weight
        edges.sort(Comparator.comparingInt(e -> e.weight));

        // Count for edges (v-1)
        int count = 1;
        int ans = 0;

        for (int i = 0; count < v; i++) {
            Edge edge = edges.get(i);
            int captainSrc = find(edge.src);
            int captainDest = find(edge.dest);

            // If both captains are not same then union otherwise continue loop
            if (captainSrc != captainDest) {
                union(captainSrc, captainDest);
                count++;
                ans += edge.weight;
            }
        }

        return ans;
    }

    static ArrayList<Integer> pair(int value, int weight) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(value); list.add(weight);
        return list;
    }
}

class Edge {
    int src, dest, weight;
    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class GraphKruskal {
    ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
    int v;
    public GraphKruskal(int v) {
        this.v = v;
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest, int weight) {
        adj.get(src).add(pair(dest, weight));
        adj.get(dest).add(pair(src, weight));
    }

    static ArrayList<Integer> pair(int value, int weight) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(value); list.add(weight);
        return list;
    }
}