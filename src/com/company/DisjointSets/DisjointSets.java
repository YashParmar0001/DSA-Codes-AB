package com.company.DisjointSets;

public class DisjointSets {
    public static void main(String[] args) {
        DisjointSet set = new DisjointSet(8);
        set.union(0, 2);
        set.union(3, 5);
        System.out.println(set.isConnected(0, 3));
        set.union(0, 3);
        System.out.println(set.isConnected(0, 3));
    }
}

class DisjointSet {
    int[] parent;

    public DisjointSet(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return find(parent[a]);
    }

    void union(int a, int b) {
        int captainA = find(a);
        int captainB = find(b);

        if (captainA == captainB) {
            return;
        }
        parent[captainB] = captainA;
    }

    boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }
}
