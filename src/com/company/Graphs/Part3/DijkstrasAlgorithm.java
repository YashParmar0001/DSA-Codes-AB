package com.company.Graphs.Part3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {
    public static void main(String[] args) {
        int v = 6;
        GraphDj graph = new GraphDj(v);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 3, 5);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 4, 2);
        graph.addEdge(2, 4, 1);
        graph.addEdge(3, 5, 3);
        System.out.println(Arrays.toString(dijkstra(v, graph.adj, 0)));
    }

    static ArrayList<Integer> pair(int value, int weight) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(value); list.add(weight);
        return list;
    }

    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] distance = new int[v];
        boolean[] visited = new boolean[v];
        int[] parent = new int[v];
        parent[S] = -1;
        PriorityQueue<ArrayList<Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.get(1)));
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[S] = 0;
        queue.offer(pair(0, 0));

        while (!queue.isEmpty()) {
            ArrayList<Integer> current = queue.poll();
            if (visited[current.get(0)]) {
                continue;
            }
            visited[current.get(0)] = true;
            for (ArrayList<Integer> neighbour : adj.get(current.get(0))) {
                if (!visited[neighbour.get(0)]) {
                    if (distance[neighbour.get(0)] > distance[current.get(0)] + neighbour.get(1)) {
                        distance[neighbour.get(0)] = distance[current.get(0)] + neighbour.get(1);
                        parent[neighbour.get(0)] = current.get(0);
                        queue.offer(pair(neighbour.get(0), distance[neighbour.get(0)]));
                    }
                }
            }
        }
        System.out.println(Arrays.toString(parent));
        return distance;
    }
}

class GraphDj {
    ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
    int v;

    public GraphDj(int v) {
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
