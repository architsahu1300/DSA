package com.example.dsa;

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n=4;
        System.out.println(approach2(n));
    }
    public static int approach1(int n){
        //Here we will keep track of already encountered answers in an array
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(dp,n);
    }
    public static int solve(int[] dp,int n){
        if(n<0) return 0;
        if(n==0) return 1;
        //Already encountered before
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n]=solve(dp,n-1)+solve(dp,n-2);
        return dp[n];
    }
    public static int approach2(int n){
        //In this approach we eliminate the use of array to store prev answers to save space
        if(n<0) return 0;
        if(n==0) return 1;
        int prev1=1;
        int prev2=1;
        for(int i=2;i<=n;i++){
            int curr=prev1+prev2;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}
