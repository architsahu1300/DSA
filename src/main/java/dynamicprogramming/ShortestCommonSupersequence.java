package dynamicprogramming;

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m+1][n+1];
        System.out.println(shortestCommonSubsequence(X,Y,m,n,dp));
    }
    public static int shortestCommonSubsequence(String X, String Y, int m, int n, int[][] dp){
        //Initialisation
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
        //length(s1) + length(s2) - length(LCS)
        //Above will give us the SCS because we removed one of the occurrences of every character in LCS to get it.
        return m+n-dp[m][n];
    }
}
