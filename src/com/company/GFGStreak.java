package com.company;

import java.util.Arrays;

public class GFGStreak {
    public static void main(String[] args) {
        int[] arr = {20, 2};
        System.out.println(minSubset(arr, arr.length));
    }

    static int minSubset(int[] Arr,int N) {
        long sum=0;
        Arrays.sort(Arr);
        for(int i=0;i<N;i++){
            sum+=Arr[i];
        }
        long res=0;
        for(int i=N-1;i>=0;i--){
            res+=Arr[i];
            sum-=Arr[i];
            if(res>sum){
                return N-i;
            }
        }
        return N;
    }
}
