package com.example.dsa;

public class BuySellStocks2 {
    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        int profit=maxProfit(prices);
        System.out.println(profit);
    }
    public static int maxProfit(int[] prices){
        int profit=0;
        //Buy Sell Stocks 1
//        for(int i=0;i<prices.length;i++){
//            if(minTillNow>prices[i]){
//                minTillNow=prices[i];
//            }
//            maxProfit=Math.max(maxProfit,prices[i]-minTillNow);
//        }

        //For Buy Sell Stocks 2 our logic is basically finding a local minima to buy the stock at low price,
        // and finding a local maxima to sell the stock at high price.
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                //Here the trick is that assume below example, we do not have to find the max value to sell
                //We have to sell daily until the price starts going down.
                //2,6,1,4,7,2
                //2 - 6 is fine, but we do not have to wait for 7 to sell the stock.
                //4-1 =3, 7-4=3 is same as 7-1=6.
                profit+=prices[i]-prices[i-1];
            }
        }
        return profit;
    }
}
