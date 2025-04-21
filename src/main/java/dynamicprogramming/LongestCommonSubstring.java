package dynamicprogramming;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String X = "abcdef";
        String Y = "abfce";int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m+1][n+1];
        System.out.println(longestCommonSubstring(X,Y,m,n,dp));
    }
    public static int longestCommonSubstring(String X, String Y, int m, int n, int[][] dp){
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
                    //0 because if the 2 chars are not equal we need to reset the longest substring to 0
                    //because substring is supposed to be continuous
                    dp[i][j] = 0;
                }
            }
        }
        int max=0;
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
