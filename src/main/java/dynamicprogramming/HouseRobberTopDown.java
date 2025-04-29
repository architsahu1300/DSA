package dynamicprogramming;

public class HouseRobberTopDown {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int len = nums.length;
        int[] dp = new int[len+1];
        System.out.println(maxAmount(nums,len,dp));
    }
    public static int maxAmount(int[] nums, int len, int[] dp){
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=2;i<=len;i++){
            dp[i] = Math.max(dp[i-2]+nums[i-1],dp[i-1]);
        }
        return dp[len];
    }
}
