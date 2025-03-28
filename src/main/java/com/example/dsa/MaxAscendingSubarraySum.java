package com.example.dsa;

public class MaxAscendingSubarraySum {
    public static void main(String[] args) {
        int[] nums = {10,20,30,5,10,50};
        System.out.println(maxSum(nums));
    }
    public static int maxSum(int[] nums) {
        //Sliding window problem.
        //Keep track of current Sum and check Max sum regularly
        if(nums.length==1) return nums[0];
        int maxSum = 0;
        int currSum = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<nums[i]){
                currSum += nums[i];
                maxSum = Math.max(currSum,maxSum);
            }
            else{
                //Here maxSum should be checked before assigning currSum because of such cases: [100,10,1]
                maxSum = Math.max(currSum,maxSum);
                currSum = nums[i];
            }
        }
        return maxSum;
    }
}
