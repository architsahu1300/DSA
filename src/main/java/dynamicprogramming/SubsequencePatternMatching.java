package dynamicprogramming;

public class SubsequencePatternMatching {
    public static void main(String[] args) {
        String X = "AXY";
        String Y = "ADXCPY";
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m+1][n+1];
        System.out.println(isASubsequenceOfB(X,Y,m,n,dp));
    }
    public static boolean isASubsequenceOfB(String X, String Y, int m, int n, int[][] dp){
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
        return dp[m][n]==m;
    }
}
