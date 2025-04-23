package dynamicprogramming;

public class PrintShortestCommonSupersequence {
    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m+1][n+1];
        printSCS(X,Y,m,n,dp);
    }
    public static void printSCS(String X, String Y, int m, int n, int[][] dp){
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
        StringBuilder sb = new StringBuilder(X+Y);
        int i=m;
        int j=n;
        //Method 1
        while(m>0 && n>0){
            if(X.charAt(m-1)==Y.charAt(n-1)){
                sb.deleteCharAt(m-1);
                m--;
                n--;
            }
            else{
                if(dp[m-1][n]>dp[m][n-1]){
                    m--;
                }
                else{
                    n--;
                }
            }
        }
        System.out.println(sb);
        //Method 2
        StringBuilder sb1 = new StringBuilder();
        while(i>0 && j>0){
            if(X.charAt(i-1)==Y.charAt(j-1)){
                sb1.append(X.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(dp[i-1][j]>dp[i][j-1]){
                    sb1.append(X.charAt(i-1));
                    i--;
                }
                else{
                    sb1.append(Y.charAt(j-1));
                    j--;
                }
            }
        }
        while(i>0){
            sb1.append(X.charAt(i-1));
            i--;
        }
        while(j>0){
            sb1.append(Y.charAt(j-1));
            j--;
        }
        System.out.println(sb1.reverse());
    }
}
