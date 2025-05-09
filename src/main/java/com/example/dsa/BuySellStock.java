package com.example.dsa;

public class BuySellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minTillNow = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minTillNow){
                minTillNow = prices[i];
            }
            maxProfit = Math.max(maxProfit,prices[i]-minTillNow);
        }
        return maxProfit;
    }
}
