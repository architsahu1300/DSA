package com.example.dsa;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
//        int[] nums={-1,0,1,2,-1,-4};
        int[] nums={-2,-2,-2,-1,-1,-1,0,0,0,2,2,2,2};
        List<List<Integer>> result=ThreeSum(nums);
        System.out.println(result);
    }
    public static List<List<Integer>> ThreeSum(int[] nums){
        //We will sort the array because what we are going to do is:
        //Select a number, then apply twosum on remaining numbers while skipping duplicates.
        Arrays.sort(nums);
        List<List<Integer>> out=new LinkedList<>();
        for(int i=0;i<nums.length-2;i++){
            //Here we did i==0 to avoid IOB in other condition
            //And second condition is to avoid checking duplicates.
            if(i==0 || (nums[i]!=nums[i-1])){
                int low=i+1;
                int high=nums.length-1;
                while(low<high){
                    int sum=nums[i]+nums[low]+nums[high];
                    if(sum<0){
                        low++;
                    }
                    else if(sum>0){
                        high--;
                    }
                    else{
                        out.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        low++;
                        high--;
                        //Avoid duplicates by moving forward until finding another value as array has been sorted at start
                        //low<high to avoid IOB
                        while(low<high && nums[low]==nums[low-1]) low++;
                        while(low<high && nums[high]==nums[high+1]) high--;

                    }
                }
            }
        }
        return out;

    }
}
