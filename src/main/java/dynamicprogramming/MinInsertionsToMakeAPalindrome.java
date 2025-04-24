package dynamicprogramming;

public class MinInsertionsToMakeAPalindrome {
    public static void main(String[] args) {
        String X = "aebcbda";
        StringBuilder sb = new StringBuilder(X);
        int m = X.length();
        int[][] dp = new int[m+1][m+1];
        System.out.println(minInsertions(X, String.valueOf(sb.reverse()),m,m,dp));
    }
    public static int minInsertions(String X, String Y, int m, int n, int[][] dp){
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(X.charAt(i-1)==Y.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return m-dp[m][n];
    }
}
