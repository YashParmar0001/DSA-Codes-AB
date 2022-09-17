package com.company;

import java.util.*;

public class GFGStreak {
    public static void main(String[] args) {

    }

    public static int minimumSwaps(int[] c, int[] v,int n,int k,int b,int t) {
        // code here
        int swap=0;
        int temp=0;
        int cnt=0;
        for(int i=n-1;i>=0;i--){
            if(cnt<k){
                int d=v[i]*t;
                if(d>=b-c[i]){
                    swap+=temp;
                    cnt++;
                }else{
                    temp++;
                }
            }
        }
        if(cnt<k)return -1;
        return swap;
    }
}
