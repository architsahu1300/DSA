package dynamicprogramming;

import java.util.Arrays;

public class ZeroOneKnapsackMemoization {
    public static void main(String[] args) {
        int[] weight = {1,3,4,5};
        int[] value = {1,4,5,7};
        int capacity = 7;
        int len = value.length;
        int[][] dp = new int[len+1][capacity+1];
        for(int i=0;i<=len;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(maxProfit(weight,value,capacity,len,dp));
    }

    public static int maxProfit(int[] weight, int[] value, int capacity, int len, int[][] dp){
        if(len==0 || capacity ==0)
            return 0; //No profit in these 2 cases
        if(dp[len][capacity]!=-1)
            return dp[len][capacity];
        if(weight[len-1]<=capacity){
            return dp[len][capacity]=Math.max(value[len-1]+maxProfit(weight,value,capacity-weight[len-1],len-1,dp),maxProfit(weight,value,capacity,len-1,dp));
        }
        else{
            return dp[len][capacity]=maxProfit(weight,value,capacity,len-1,dp);
        }
    }
}
