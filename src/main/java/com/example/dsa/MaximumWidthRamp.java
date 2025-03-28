package com.example.dsa;

public class MaximumWidthRamp {
    public static void main(String[] args) {
        int[] nums={6,0,8,1,2,0,5};
        System.out.println(maxWidthRamp(nums));
    }
    public static int maxWidthRamp(int[] nums){

        //Here intuition is that we want a sliding window where we find the last number which is GE left pointer of window
        //For that the brute force will check for all possible maximum windows in O(n^2) time
        //OPTIMIZED:
        //Basic idea is that we want the last number in nums after left which is GE the left number of window
        //For above array we will pre-process and store the information of the largest number to the right of every number
        //It looks something like this for above example: [8,8,8,5,5,5,5]

        //So when comparing nums[left] to above maxArr we know already that there exists a number >=nums[left] to the right
        int result=0;
        int[] maxToRightArr=new int[nums.length];
        int tempMax=nums[nums.length-1];
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>tempMax){
                tempMax=nums[i];
                maxToRightArr[i]=tempMax;
            }
            else{
                maxToRightArr[i]=tempMax;
            }
        }

        int left=0;
        int right=1;
        while(right<=nums.length-1){
           while(nums[left]>maxToRightArr[right]){
               left++;
           }
           result=Math.max(result,right-left);
           right++;
        }


        return result;
    }
}
