package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GFGStreak {
    public static void main(String[] args) {
        ArrayList<Long> list = new ArrayList<>();
        list.add(3L); list.add(5L); list.add(7L);
        System.out.println(numberOfSubsequences(list.size(), list));
    }

    static long mod=1000000007;
    static Long numberOfSubsequences(int N, ArrayList<Long> A){
        // code here
        int cnt=0;
        for(int i=0;i<N;i++){
            //checking power of 2.
            if((A.get(i)&A.get(i)-1)==0){
                cnt++;
            }
        }
        //answer goes like this:
        //nC1 + nC2 + nC3 + ... + nCn = 2^n - 1;
        long ans=modpwr(2,cnt)-1;
        Long a=ans;
        return a;
    }
    static long modpwr(long m,long n)
    {
        long res=1;
        m=m%mod;
        if(m==0)
            return 0;
        while(n>0)
        {
            if((n&1)!=0)
            {
                res=(res*m)%mod;
            }
            n=n>>1;
            m=(m*m)%mod;
        }
        return res;
    }

    static Set<Long> set = new HashSet<>();
    static ArrayList<Long> ansList = new ArrayList<>();

    static Long numberOfSubsequences1(int N, ArrayList<Long> A){
        long ans = 0;
        subseq(A, 0, 1);
        for (long e : ansList) {
            double d = Math.log10(e)/Math.log10(2);
            if (d == (long)d) ans++;
        }
        return ans-1;
    }

    static void subseq(ArrayList<Long> list, int i, long value) {
        if (i == list.size()) {
            ansList.add(value);
            return;
        }

        subseq(list, i+1, value * list.get(i));
        subseq(list, i+1, value);
    }
}
