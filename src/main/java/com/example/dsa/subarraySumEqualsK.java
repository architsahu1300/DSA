package com.example.dsa;

import java.util.HashMap;

public class subarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums={-1,-1,1};
        int k=3;
        System.out.println(subarraysSumEqualsK(nums,k));
    }
    public static int subarraysSumEqualsK(int[] nums,int k){
        int count=0;
        int currSum=0;
        HashMap<Integer,Integer> hmap=new HashMap<>();
        //This is to ensure hashmap has (0,1) because if we encounter 0 somewhere in between we will increase counter to 2
        //Since (0,1) is the initial situation as well (without removing anything)
        hmap.put(0,1);
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
        }
        return count;
    }
}
