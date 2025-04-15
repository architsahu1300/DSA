package dynamicprogramming;

public class CountOfSubsetSumTopDown {
    public static void main(String[] args) {
        int[] nums = {2,3,5,6,7,8,10};
        int sum = 10;
        int len = nums.length;
        int[][] dp = new int[len+1][sum+1];
        for(int i=0;i<=len;i++){
            for(int j=0;j<=sum;j++){
                if(j==0){
                    dp[i][j]=1;
                }
                if(i==0 && j!=0){
                    dp[i][j]=0;
                }
            }
        }
        System.out.println(numOfSubsets(nums,sum,len,dp));
    }
    public static int numOfSubsets(int[] nums, int sum, int len, int[][] dp){
        for(int i=1;i<=len;i++){
            for(int j=1;j<=sum;j++){
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[len][sum];
    }
}
