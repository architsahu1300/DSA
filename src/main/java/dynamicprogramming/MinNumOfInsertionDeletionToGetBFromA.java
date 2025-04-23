package dynamicprogramming;

public class MinNumOfInsertionDeletionToGetBFromA {
    public static void main(String[] args) {
        String X = "heap";
        String Y = "pea";
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m+1][n+1];
        System.out.println(minOperations(X,Y,m,n,dp));
    }
    public static int minOperations(String X, String Y , int m, int n, int[][] dp){
        //Initialisation
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0) dp[i][j]=0;
            }
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(X.charAt(i-1)==Y.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int lengthOfLCS = dp[m][n];
        return m+n-2*lengthOfLCS;
    }
}
