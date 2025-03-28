package com.example.dsa;

public class SearchInsertPosition {
    public static void main(String[] args) {
        //Basically a binary search
        int target=7;
        int[] nums={1,3,4,6};
        int result=searchInsert(nums,target);
        System.out.println(result);
    }
    public static int searchInsert(int[] nums,int target){
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return start;
    }
}
