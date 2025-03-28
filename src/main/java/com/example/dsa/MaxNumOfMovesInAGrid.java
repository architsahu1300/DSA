package com.example.dsa;

public class MaxNumOfMovesInAGrid {
    static int m,n;
    //Creating directions array for possible movements inside DFS
    static int[] directions={-1,0,1};
    public static void main(String[] args) {
        int[][] grid={{2,4,3,5},{5,4,9,3},{3,4,2,11},{10,9,13,15}};
        System.out.println(maxMovesInGrid(grid));
    }
    public static int maxMovesInGrid(int[][] grid){
        //Below Approach will throw Time Limit Exceeded
        //For memoization in this case we will need a 2D array since row and col are 2 things changing in each iteration
        //So to uniquely identify we will need 2D array
        m=grid.length;
        n=grid[0].length;
        int result=0;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        //Loop through all rows in 1st column since question states we can take any cell in 1st col as starting
        //Then for each cell we will run a DFS function which will give us max num of moves from each cell
        for(int row=0;row<m;row++){
            //We are passing 0 in column as we have to start from 1st column cells only
            result=Math.max(result,depthFirstSearch(row,0,grid,dp));
        }
        return result;
    }
    public static int depthFirstSearch(int row, int col, int[][] grid, int[][] dp){
        int movesFromThisPos=0;
        int newRow,newCol;
        if(dp[row][col]!=-1) return dp[row][col];
        //go recursively to each possibility and get max moves
        for(int dir:directions){
            newRow=row+dir;
            newCol=col+1;
            if(newRow<m && newRow>=0 && newCol<n && grid[newRow][newCol]>grid[row][col]){
                movesFromThisPos=Math.max(movesFromThisPos,1+depthFirstSearch(newRow,newCol,grid,dp));
            }
        }
        return dp[row][col]=movesFromThisPos;
    }
}
