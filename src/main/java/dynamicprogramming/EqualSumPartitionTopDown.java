package dynamicprogramming;

public class EqualSumPartitionTopDown {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        int len = nums.length;
        int sum=0;
        for(int n:nums){
            sum+=n;
        }
        if(sum%2!=0) {
            System.out.println(false);
            return;
        }
        boolean[][] dp = new boolean[len+1][sum/2+1];
        for(int i=0;i<=len;i++){
            for(int j=0;j<=sum/2;j++){
                if(j==0){
                    dp[i][j]=true;
                }
                if(i==0 && j!=0){
                    dp[i][j]=false;
                }
            }
        }
        System.out.println(isPartitionPossible(nums,sum/2,len,dp));
    }
    public static boolean isPartitionPossible(int[] nums, int sum, int len, boolean[][] dp){
        for(int i=1;i<=len;i++){
            for(int j=1;j<=sum;j++){
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[len][sum];
    }
}
