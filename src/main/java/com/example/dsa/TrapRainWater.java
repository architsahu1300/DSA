package com.example.dsa;

public class TrapRainWater {
    public static void main(String[] args) {
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        int out=rainWater(height);
        System.out.println(out);
    }
    public static int rainWater(int[] height){
        //Concept here is that any index can store water only when someone in right or left has a building taller than itself
        //We make left and right array to check what are the max height buildings on left and right sides of any building
        int n= height.length;
        int[] left=new int[n];
        int[] right=new int[n];
        left[0]=height[0];
        for(int i=1;i<n;i++){
            left[i]=Math.max(left[i-1],height[i]);
        }
        right[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            right[i]=Math.max(right[i+1],height[i]);
        }
        int water=0;
        for(int i=0;i<n;i++){
            water+=Math.min(left[i],right[i])-height[i];
        }
        return water;
    }
}
