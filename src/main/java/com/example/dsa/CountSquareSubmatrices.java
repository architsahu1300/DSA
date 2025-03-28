package com.example.dsa;

import java.util.Arrays;

public class CountSquareSubmatrices {
    static int n,m;
    public static void main(String[] args) {
        int[][] matrix={{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        System.out.println(numOfSquareSubmatrices(matrix));
    }
    //Recursive approach will give Time Limit Exceeded, we will need memoization
    public static int numOfSquareSubmatrices(int[][] matrix){
        int result=0;
        //Go to right, below and diagonal direction and check the number of 1s.
        //The minimum number of 1s in these 3 directions will give us the max size of submatrix with all 1s
        m=matrix.length;
        n=matrix[0].length;
        //Create dp for memoization
        int[][] dp=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1; // Initialize the memoization table with -1
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                    result+=solve(i,j,matrix,dp);
            }
        }

        return result;
    }
    public static int solve(int i, int j, int[][] matrix,int[][] dp){
        if(i>=matrix.length || j>=matrix[0].length){
            return 0;
        }
        if(matrix[i][j]==0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int right=solve(i,j+1,matrix,dp);
        int below=solve(i+1,j,matrix,dp);
        int diag=solve(i+1,j+1,matrix,dp);
        //Adding 1 since this is already a position with "1"
        return dp[i][j]=1+Math.min(right,Math.min(below,diag));
    }
}
