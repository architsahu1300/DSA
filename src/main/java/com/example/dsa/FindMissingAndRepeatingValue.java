package com.example.dsa;

import java.util.Arrays;
import java.util.HashMap;

public class FindMissingAndRepeatingValue {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 2, 3}, {4, 1, 6}, {7, 8, 5}};
        System.out.println(Arrays.toString(missingAndRepeating(grid)));
    }
    public static int[] missingAndRepeating(int[][] grid) {
        int sum = 0;
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                map.put(grid[i][j], map.getOrDefault(grid[i][j], 0) + 1);
                sum += grid[i][j];
            }
        }
        for(int i:map.keySet()) {
            if(map.get(i)==2){
                ans[0] = i;
            }
        }
        int sumOfN=grid.length*grid.length*(grid.length*grid.length+1)/2;
        if(sum>sumOfN){
            ans[1]=ans[0]-(sum-sumOfN);
        }
        else{
            ans[1]=ans[0]+(sumOfN-sum);
        }
        return ans;
    }
}
