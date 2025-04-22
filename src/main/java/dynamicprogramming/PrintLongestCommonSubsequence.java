package dynamicprogramming;

public class PrintLongestCommonSubsequence {
    public static void main(String[] args) {
        String X = "aba";
        String Y = "abcdaf";
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m+1][n+1];
        printLCS(X,Y,m,n,dp);
    }
    public static void printLCS(String X, String Y, int m, int n, int[][] dp){
        //Initialisation
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        //Filling the Matrix
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
        StringBuilder sb = new StringBuilder();
        while(m>0 && n>0){
            if(X.charAt(m-1)==Y.charAt(n-1)){
                //Append only if characters match
                sb.append(X.charAt(m-1));
                m--;
                n--;
            }
            else{
                //Moving up and down on the matrix based on Max out of two cells
                if(dp[m-1][n]>dp[m][n-1]){
                    m--;
                }
                else{
                    n--;
                }

            }
        }
        System.out.println(sb.reverse());
    }
}
