package com.example.dsa;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost={1,100,1,1,1,100,1,1,100,1};
        System.out.println(recursive(cost));
    }
    //Recursive approac
    public static int recursive(int[] cost){
        int n=cost.length;
        return solve(cost,n);

    }
    public static int solve(int[] cost,int n){
        if(n<2) return 0;
        return Math.min(cost[n-2]+solve(cost,n-2),cost[n-1]+solve(cost,n-1));
    }

    //Greedy approach
    public static int greedy(int[] cost){
        //This is the greedy approach where we will modify the cost array to keep track of the cost till ith index
        for(int i=2;i<cost.length;i++){
            cost[i]+=Math.min(cost[i-1],cost[i-2]);
        }
        return Math.min(cost[cost.length-1],cost[cost.length-2]);
    }

    //Dynamic programming approach
    public static int dynamic(int[] cost){
        int[] dp=new int[cost.length+1];
        dp[0]=0;
        dp[1]=0;
        return solveDp(cost,2);
    }
    public static int solveDp(int[] dp,int n){
        return 0;
    }
}
