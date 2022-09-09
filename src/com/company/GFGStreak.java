package com.company;

public class GFGStreak {
    public static void main(String[] args) {
        System.out.println(digitsNum(5000));
    }

    static String digitsNum(int N)
    {
        // Code here
        int temp=N/9;
        StringBuilder sb=new StringBuilder();
        if(N%9!=0)sb.append(N%9);
        sb.append("9".repeat(Math.max(0, temp)));
        sb.append("0".repeat(Math.max(0, N)));
        return sb.toString();
    }
}
