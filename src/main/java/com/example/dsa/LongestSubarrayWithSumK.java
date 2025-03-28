package com.example.dsa;

import java.util.HashMap;

public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        //int[] nums={1,2,3,1,1,1,1,4,2,3};
        int[] nums={2,0,0,3};
        int k=3;
        System.out.println(LongestSubarrayWithSumK(nums,k));
    }
    public static int LongestSubarrayWithSumK(int[] nums,int k){
        //BRUTE FORCE:
        //Calculate all the subarrays and get the max length subarray with sum k

        //BETTER:
        //The approach here is using hashmap. The intuition is as follows:
        //We have the array:    {1,2,3,1,1,1,1, 32, 4, 5} and below is the prefixSum array
        //The prefixSum array:  {1,3,6,7,8,9,10,42,46,51}
        //The idea here is that if we are at index 5 (nums[5]=1, prefixSum[5]=9).
        //For a subarray which ends at index 5 with sum k(3),
        // there has to be a previous prefixSum value which is equal to {prefixSum[5](9)-k(3)=6}
        //           <--sum-k(6)------>|<---k(3)-->
        //           ______________________________
        //           <--------sum(9)-------------->
        //From above diagram it is clear that there was a prefixSum value at | which was equal to (sum-k)

        int longest=0;
        int sum=0;
        HashMap<Integer,Integer> hmap=new HashMap<>();
        for(int i=1;i<nums.length;i++){
            sum=nums[i]+nums[i-1];
            nums[i]=sum;
        }
        for(int i=0;i<nums.length;i++){
            if(hmap.containsKey(nums[i]-k)){
                longest=Math.max(longest,i-hmap.get(nums[i]-k));
            }
            //We have this "if" condition because if there are 0s present in the array our output will be wrong
            //because while creating the prefixSum array we would have updated the sum as follows:
            //{2,0,0,3} -> {2,2,2,5} k=3
            //And according to our logic we would get the max length of subarray as 1 and not 3.
            //So we update the prefixSum key in the map only when the previous sum is not same.
            if(!hmap.containsKey(nums[i])) {
                hmap.put(nums[i], i);
            }
        }

        return longest;
    }
}
