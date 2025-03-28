package com.example.dsa;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
         int[] nums = new int[]{1,1,2};
        System.out.println(removeDuplicate(nums));
    }
    public static int removeDuplicate(int[] nums) {
        int k=0;
        int prev=nums[k];
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=prev){
                prev=nums[i];
                nums[++k]=nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return k+1;
    }
}
