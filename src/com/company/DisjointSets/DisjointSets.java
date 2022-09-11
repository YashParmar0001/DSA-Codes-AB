package com.company.DisjointSets;

public class DisjointSets {
    public static void main(String[] args) {
        DisjointSet set = new DisjointSet(8);
        set.union(0, 2);
        set.union(3, 5);
//        System.out.println(set.isConnected(0, 3));
        set.union(0, 3);
//        System.out.println(set.isConnected(0, 3));
        set.union(5, 6);
        set.union(6, 7);
        System.out.println(set.isConnected(0, 7));
    }
}

class DisjointSet {
    int[] parent;
    int[] rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int a) {
        if (a != parent[a]) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }

    // Union Find (Simple)
//    void union(int a, int b) {
//        int captainA = find(a);
//        int captainB = find(b);
//
//        if (captainA == captainB) {
//            return;
//        }
//        parent[captainB] = captainA;
//    }

    // Union find - With rank
    void union(int a, int b) {
        int captainA = find(a);
        int captainB = find(b);

        if (captainA == captainB) return;

        if (rank[captainA] < rank[captainB]) {
            parent[captainA] = captainB;
        }else if (rank[captainB] < rank[captainA]) {
            parent[captainB] = captainA;
        }else {
            parent[captainB] = captainA;
            rank[captainA]++;
        }
    }

    boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }
}
