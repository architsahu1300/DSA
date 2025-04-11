package dynamicprogramming;

public class ZeroOneKnapsackTopDown {
    public static void main(String[] args) {
        int[] weight = {1,3,4,5};
        int[] value = {1,4,5,7};
        int capacity = 7;
        int len = weight.length;
        int[][] dp = new int[len+1][capacity+1];
        //Filling 0th row and column with base condition's return value to replicate base condition
        for(int i=0;i<=len;i++){
            for(int j=0;j<=capacity;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        System.out.println(maxProfit(weight,value,capacity,len,dp));
    }
    public static int maxProfit(int[] weight, int[] value, int capacity,int len,int[][] dp){
        //Starting with 1 as 0 is already filled
        for(int i=1;i<=len;i++){
            for(int j=1;j<=capacity;j++){
                if(weight[i-1]<=j){
                    dp[i][j]=Math.max(value[i-1]+dp[i-1][j-weight[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[len][capacity];
    }
}
