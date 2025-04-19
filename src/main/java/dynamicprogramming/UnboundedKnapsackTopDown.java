package dynamicprogramming;

public class UnboundedKnapsackTopDown {
    public static void main(String[] args) {
        int[] weight = {1,2,3,5};
        int[] value = {2,3,4,6};
        int capacity = 7;
        int len = weight.length;
        int[][] dp = new int[len+1][capacity+1];
        System.out.println(maxProfit(weight,value,capacity,len,dp));
    }
    public static int maxProfit(int[] weight, int[] value, int capacity, int len, int[][] dp){
        //Initialisation
        for(int i=0;i<=len;i++){
            for(int j=0;j<=capacity;j++){
                if(i==0 || j==0) dp[i][j]=0;
            }
        }
        for(int i=1;i<=len;i++){
            for(int j=1;j<=capacity;j++){
                if(weight[i-1]<=j){
                    dp[i][j] = Math.max(value[i-1] + dp[i][j-weight[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[len][capacity];
    }
}
