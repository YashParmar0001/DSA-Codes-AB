package com.company;

import java.util.*;

public class GFGStreak {
    public static void main(String[] args) {

    }

    static class Node implements Comparator<Node> {
        int v;
        int time;
        Node(){}
        Node(int v,int time){
            this.v = v;
            this.time = time;
        }

        public int compare(Node n1, Node n2){
            if(n1.time<n2.time){
                return -1;
            }
            if(n1.time>n2.time){
                return 1;
            }
            return 0;
        }
    }
    static int countPaths(int n, List<List<Integer>> roads) {
        int[] distance = new int[n];
        int[] ways = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);

        // Building Adj list
        List<List<Node>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> a: roads){

            int u = a.get(0);
            int v = a.get(1);
            int t = a.get(2);
            adj.get(u).add(new Node(v,t));
            adj.get(v).add(new Node(u,t));
        }
        // Dijkstra's  Algo Starts from here
        PriorityQueue<Node> pq = new PriorityQueue<Node>(n,new Node());
        pq.add(new Node(0,0));
        distance[0] = 0;
        ways[0] = 1;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(distance[node.v] < node.time)continue;
            for(Node it:adj.get(node.v)){
                if(distance[node.v] + it.time < distance[it.v]){
                    ways[it.v] = ways[node.v];
                    distance[it.v] = distance[node.v] + it.time;
                    pq.add(new Node(it.v,distance[it.v]));
                }
                else if(distance[node.v] + it.time == distance[it.v]){
                    ways[it.v] = (ways[it.v] + ways[node.v]);
                }
            }
        }

        return ways[n-1];
    }
}
