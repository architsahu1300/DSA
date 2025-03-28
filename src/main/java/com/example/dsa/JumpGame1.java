package com.example.dsa;

public class JumpGame1 {
    public static void main(String[] args) {
        int[] arr={3,2,1,0,4};
        //int[] arr={2,3,1,1,2};
        //We want to know if we can reach the end of array from beginning of array given each number is max jump size
        //We start from end and come to start checking if we can reach current step from the current-1 step.
        int prevReachableIndex=arr.length-1;
        for(int i=prevReachableIndex;i>=0;i--){
            if(i+arr[i]>=prevReachableIndex){
                prevReachableIndex=i;
            }
        }
        //if prevReachableIndex is 0 it means we can reach from start to end
        System.out.println(prevReachableIndex==0);
    }
}
