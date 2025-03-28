package com.example.dsa;


public class MinSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums={2,3,1,2,4,3};
        int target=7;
        int size=minSizeSubarray(nums,target);
        System.out.println(size);
    }
    public static int minSizeSubarray(int[] nums,int target){

        //BRUTE FORCE:
        //We take a window size starting from 1 and increase it to check if any subarray of that window size has required sum

        //OPTIMIZED:
        //We take a "variable" sliding window with two pointers
        //While iterating through the array we keep the currentSum to check our target
        //Initially minWindow is Infinite, and we will update the minWindow when we find currentSum >= target
        //Once we find currentSum >= target we will try to reduce window size from the left by subtracting that element from currentSum
        //Doing this till end will give us the minWindow size whose sum is greater than or equal to target
        int minWindow= Integer.MAX_VALUE;
        int currentSum=0;

        int left=0;
        int right=0;

        while(right<nums.length){
            currentSum+=nums[right];
            while(currentSum>=target){
                minWindow=Math.min(minWindow,right-left+1);
                currentSum-=nums[left++];
            }
            right++;
        }
        return minWindow!=Integer.MAX_VALUE?minWindow:0;
    }
}
