package com.example.dsa;

public class CheckIfArraySortedAndRotated {
    public static void main(String[] args) {
        int[] nums={2, 1, 3, 4};
        System.out.println(isItSortedAndRotated(nums));
    }
    public static boolean isItSortedAndRotated(int[] nums) {
        int isSorted=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                isSorted++;
            }
        }
        return (isSorted == 1 && !(nums[0] < nums[nums.length - 1])) || isSorted == 0;
    }
}
