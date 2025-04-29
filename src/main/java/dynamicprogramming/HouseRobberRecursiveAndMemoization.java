package dynamicprogramming;

import java.util.Arrays;

public class HouseRobberRecursiveAndMemoization {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int len = nums.length;
        int[] dp = new int[len+1];
        Arrays.fill(dp,-1);
        System.out.println(maxAmount(nums,len));
        System.out.println(maxAmount(nums,len,dp));
    }
    public static int maxAmount(int[] nums, int len){
        if(len<=0) return 0;
        return Math.max(nums[len-1]+maxAmount(nums,len-2),maxAmount(nums,len-1));
    }
    public static int maxAmount(int[] nums, int len, int[] dp){
        if(len<=0) return 0;
        if(dp[len]!=-1){
            return dp[len];
        }
        return dp[len]=Math.max(nums[len-1]+maxAmount(nums,len-2),maxAmount(nums,len-1));
    }
}
