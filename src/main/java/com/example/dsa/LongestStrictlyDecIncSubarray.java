package com.example.dsa;

public class LongestStrictlyDecIncSubarray {
    public static void main(String[] args) {
        //Strictly inc subarrays are: [1],[4],[3],[3],[2],[1,4]
        //Strictly dec subarrays are: [1],[4],[3],[3],[2],[3,2]
        //So length of longest strictly inc/dec subarray is 2
        int[] nums = new int[]{1, 4, 3, 1, 3, 2};
        System.out.println(longestIncDecSubarray(nums));
    }
    public static int longestIncDecSubarray(int[] nums) {
        //Keep track of longest inc and dec length subarray
        //Reset inc length to 1 if nums[i] < nums[i-1] and vice versa
        int longest = 1;
        int inc=1;
        int dec=1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                inc++;
                dec=1;
                longest = Math.max(longest, Math.max(inc, dec));
            }
            else if(nums[i]<nums[i-1]){
                inc=1;
                dec++;
                longest = Math.max(longest, Math.max(inc, dec));
            }
            else{
                inc=1;
                dec=1;
            }
        }
        return longest;
    }
}
