package dynamicprogramming;

public class CoinChange2 {
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int sum = 5;
        int len = coins.length;
        int[][] dp = new int[len+1][sum+1];
        System.out.println(minNumOfCoins(coins,sum,len,dp));
    }
    public static int minNumOfCoins(int[] coins, int sum, int len, int[][] dp){
        //Initialisation with twist. Check notes
        for(int i=0;i<=len;i++){
            for(int j=0;j<=sum;j++){
                if(i==0) dp[i][j]=Integer.MAX_VALUE-1;
                if(j==0 && i!=0) dp[i][j]=0;
                if(i==1 && j!=0){
                    if(j%coins[0]==0){
                        dp[i][j] = j/coins[0];
                    }
                    else{
                        dp[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
        }

        for(int i=2;i<=len;i++){
            for(int j=1;j<=sum;j++){
                if(coins[i-1]<=j){
                    //Adding 1 as we took this coin in consideration
                    dp[i][j] = Math.min(1 + dp[i][j-coins[i-1]],
                            dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[len][sum];
    }
}
