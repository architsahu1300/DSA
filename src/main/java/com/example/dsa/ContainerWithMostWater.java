package com.example.dsa;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] heights={1,8,6,2,5,4,8,3,7};
        int result=MostWater(heights);
        System.out.println(result);
    }
    public static int MostWater(int[] heights){
        int area=0;
        int i=0;
        int j=heights.length-1;
        while(i<=j){
            int currArea=Math.min(heights[i],heights[j])*(j-i);
            area=Math.max(area,currArea);
            if(heights[i]<heights[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return area;
    }
}
