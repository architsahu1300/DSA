package dynamicprogramming;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String X = "AABEBCDD";
        int m = X.length();
        int[][] dp = new int[m+1][m+1];
        System.out.println(longestRepeatingSubsequence(X,X,m,m,dp));
    }
    public static int longestRepeatingSubsequence(String X, String Y, int m, int n, int[][] dp){
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                //Condition that same characters must not be in same index, i.e., they will exist at least twice
                if(X.charAt(i-1)==Y.charAt(j-1) && i!=j){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
