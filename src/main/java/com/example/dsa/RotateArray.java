package com.example.dsa;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        int k=3;
        rotate(nums,k);
    }
    public static void rotate(int[] nums, int k) {
        //Reverse the complete array
        rotateFromI(nums,0,nums.length);

        //Reverse the array till k
        //k%nums.length because, if length=4 and k=7 then effectively there are only 7%4 rotations
        // because after 4 rotations we will have the original array back
        rotateFromI(nums,0,k%nums.length);

        //Reverse the array from k to end
        rotateFromI(nums,k%nums.length,nums.length);
    }
    public static void rotateFromI(int[] nums, int start, int end) {
        for(int i=0; i<(end-start)/2; i++){
            int temp = nums[start+i];
            nums[start+i] = nums[end-1-i];
            nums[end-1-i] = temp;
        }
        System.out.println(Arrays.toString(nums));
    }
}
