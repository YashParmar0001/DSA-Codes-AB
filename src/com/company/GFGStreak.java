package com.company;

public class GFGStreak {
    public static void main(String[] args) {

    }

    public int[][] solveQueries(int n, int[][] Queries) {
        // Code here
        int a[][]=new int[n][n];
        for(int i=0;i<Queries.length;i++){
            int x1=Queries[i][0];
            int y1=Queries[i][1];
            int x2=Queries[i][2];
            int y2=Queries[i][3];
            a[x1][y1]++;
            if(x2<n-1){
                a[x2+1][y1]--;
            }
            if(y2<n-1){
                a[x1][y2+1]--;
            }
            if(x2<n-1 && y2<n-1){
                a[x2+1][y2+1]++;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                a[i][j]+=a[i][j-1];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                a[j][i]+=a[j-1][i];
            }
        }
        return a;
    }
}
