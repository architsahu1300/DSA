package dynamicprogramming;

import java.util.Arrays;

public class LongestCommonSubsequenceMemoization {
    public static void main(String[] args) {
        String X = "";
        String Y = "abghghghgedfr";
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(longestCommonSubsequence(X,Y,m,n,dp));
    }
    public static int longestCommonSubsequence(String X, String Y, int m, int n, int[][] dp){
        if(m==0 || n==0) return 0;
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        if(X.charAt(m-1) == Y.charAt(n-1)){
            return dp[m][n] = 1+longestCommonSubsequence(X,Y,m-1,n-1,dp);
        }
        else{
            return dp[m][n] = Math.max(longestCommonSubsequence(X,Y,m-1,n,dp),longestCommonSubsequence(X,Y,m,n-1,dp));
        }
    }
}
