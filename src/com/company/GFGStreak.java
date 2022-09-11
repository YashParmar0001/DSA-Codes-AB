package com.company;

public class GFGStreak {
    public static void main(String[] args) {

    }

    public int findOccurrence(char mat[][], String target)
    {
        // Write your code here
        int n=mat.length;
        int m=mat[0].length;
        int ans=0;
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==target.charAt(0)){
                    cnt=fun(mat,target,1,i,j,-1,-1,n,m);
                    ans+=cnt;
                }
            }
        }
        return ans;
    }
    int dx[]={0,0,-1,1};
    int dy[]={-1,1,0,0};
    public int fun(char mat[][],String s,int in,int i,int j,int previ,int prevj,int n,int m)
    {
        if(in==s.length()){
            return 1;
        }
        int ans=0;

        char temp=mat[i][j];
        mat[i][j]='*';

        for(int k=0;k<4;k++){
            int nx=i+dx[k];
            int ny=j+dy[k];
            if(nx==previ && ny==prevj)continue;

            if(nx>=0 && nx<n && ny>=0 && ny<m && mat[nx][ny]==s.charAt(in)){
                ans+=fun(mat,s,in+1,nx,ny,i,j,n,m);
            }
        }

        mat[i][j]=temp;

        return ans;
    }
}
