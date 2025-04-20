package dynamicprogramming;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int sum = 5;
        int len = coins.length;
        int[][] dp = new int[len+1][sum+1];
        System.out.println(numOfWays(coins,sum,len,dp));
    }
    public static int numOfWays(int[] coins, int sum ,int len, int[][] dp){
        //Initialisation
        for(int i=0;i<=len;i++){
            for(int j=0;j<=sum;j++){
                if(j==0){
                    dp[i][j]=1;
                }
                if(i==0 && j!=0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<=len;i++){
            for(int j=1;j<=sum;j++){
                if(coins[i-1]<=j){
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[len][sum];
    }

}
