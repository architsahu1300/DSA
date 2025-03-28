package com.example.dsa;

public class CountNumOfMaximumBitwiseOR {
    public static void main(String[] args) {
        int[] nums={3,1,2,5};
        System.out.println(numOfMaxBitwiseOrSubsets(nums));
    }
    public static int numOfMaxBitwiseOrSubsets(int[] nums){
        //Max bitwise OR will be the bitwise OR of all the elements of nums
        int max=0;
        for(int num:nums){
            max=max|num;
        }
        //Now to get the subsets, we will use the approach of taking and not taking every element.
        //In one case we take 3 then won't take 3. Then we continuing forward we will make two cases, take 1 and not take 1 and so on.
        return solve(0, 0, nums, max);
    }
    public static int solve(int i, int or, int[] nums, int max){
        int ans=0;
        if(i==nums.length){
            if(or==max) return 1;
            return 0;
        }
        //take
        ans+=solve(i+1, or|nums[i], nums,max);
        //Don't take
        ans+=solve(i+1,or,nums,max);
        return ans;
    }
}
