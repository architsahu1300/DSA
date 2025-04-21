package dynamicprogramming;

public class LongestCommonSubsequenceRecursive {
    public static void main(String[] args) {
        String X = "abcdgh";
        String Y = "abedfhr";
        int m = X.length();
        int n = Y.length();
        System.out.println(longestCommonSubsequence(X,Y,m,n));
    }
    public static int longestCommonSubsequence(String X, String Y, int m, int n){
        if(m==0 || n==0) return 0;
        if(X.charAt(m-1) == Y.charAt(n-1)){
            return 1+longestCommonSubsequence(X,Y,m-1,n-1);
        }
        else{
            return Math.max(longestCommonSubsequence(X,Y,m-1,n),longestCommonSubsequence(X,Y,m,n-1));
        }
    }
}
