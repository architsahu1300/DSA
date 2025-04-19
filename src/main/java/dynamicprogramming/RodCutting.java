package dynamicprogramming;

public class RodCutting {
    public static void main(String[] args) {
        int[] length = {1,2,3,4};
        int[] price = {2,3,8,8};
        int N = 6;
        int len = length.length;
        int[][] dp = new int[len+1][N+1];
        System.out.println(maxPrice(length,price,N,len,dp));
    }
    public static int maxPrice(int[] length, int[] price, int N, int len, int[][] dp){
        for(int i=0;i<=len;i++){
            for(int j=0;j<=N;j++){
                if(i==0 || j==0) dp[i][j]=0;
            }
        }
        for(int i=1;i<=len;i++){
            for(int j=1;j<=N;j++){
                if(length[i-1]<=j){
                    dp[i][j] = Math.max(price[i-1]+dp[i][j-length[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[len][N];
    }
}
