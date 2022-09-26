package com.company.Graphs.Part3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumSpanningTree {
    public static void main(String[] args) {
        int v = 5;
        Graph graph = new Graph(v);
        graph.addUDEdge(0, 1, 7);
        graph.addUDEdge(0, 2, 8);
        graph.addUDEdge(0, 3, 3);
        graph.addUDEdge(1, 4, 2);
        graph.addUDEdge(1, 3, 1);
        graph.addUDEdge(1, 2, 2);
        graph.addUDEdge(2, 3, 1);
        graph.addUDEdge(3, 4, 5);
        System.out.println(primsMST(v, graph.adj));
    }

    static int primsMST(int v, ArrayList<ArrayList<Pair>> adj) {
        int[] distance = new int[v];
        boolean[] visited = new boolean[v];
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
//        PriorityQueue<Pair> queue = new PriorityQueue<>((p1, p2) -> p1.weight - p2.weight);

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        queue.add(new Pair(0, 0));

        int ans = 0;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            if (visited[current.value]) {
                continue;
            }
            visited[current.value] = true;
            ans += distance[current.value];

            for (Pair neighbour : adj.get(current.value)) {
                if (!visited[neighbour.value]) {
                    if (distance[neighbour.value] > neighbour.weight) {
                        distance[neighbour.value] = neighbour.weight;
                        queue.add(new Pair(neighbour.value, neighbour.weight));
                    }
                }
            }
        }

        System.out.println(Arrays.toString(distance));
        return ans;
    }
}