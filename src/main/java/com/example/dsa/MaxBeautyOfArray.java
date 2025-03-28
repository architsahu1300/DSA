package com.example.dsa;

import java.util.Arrays;

public class MaxBeautyOfArray {
    public static void main(String[] args) {
        int[] nums={1,1,1,1};
        int k = 10;
        System.out.println(maxBeauty(nums,k));
    }
    public static int maxBeauty(int[] nums, int k) {
        //Once we sort the array it becomes a problem of maximum subarray which satisfies the condition a[i]-a[j]<=2*k
        //Sliding window is used
        Arrays.sort(nums);
        int count=0;
        int left=0;
        for(int right=1;right<nums.length;right++){
            while(nums[right]-nums[left]>2*k){
                left++;
            }
            count = Math.max(count,right-left+1);
        }
        return count;
    }
}
