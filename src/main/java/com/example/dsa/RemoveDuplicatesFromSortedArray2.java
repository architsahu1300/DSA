package com.example.dsa;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray2 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums) {
        if(nums.length<3) return nums.length;
        //We are starting from 3rd index because the 1st 2 elements whether same or not doesn't need any update
        int k=2;
        //k ko sirf tab update krna hai jab 2 baar se kam aa rha hai same number.
        //jab k-2 wala number is same as i wala number, k me 2 baar already update ho chuka hai ye number so don't update now
        //i wala number ab kitni bhi baar aa jaye doesn't matter. We are updating k only when we find number <=2 times
        for(int i=2;i<nums.length;i++){
            if(nums[i]!=nums[k-2]){
                nums[k++]=nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return k;
    }
}
