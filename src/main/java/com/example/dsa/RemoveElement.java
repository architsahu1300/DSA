package com.example.dsa;

public class RemoveElement {
    public static void main(String[] args) {
        int val=3;
        int[] nums={3,2,4,3};
        int k=remove(nums,val);
        for(int i=0;i<k;i++){
            System.out.println(nums[i]);
        }
    }
    public static int remove(int[] nums, int val){
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[k++]=nums[i];
            }
        }
        return k;
    }
}
