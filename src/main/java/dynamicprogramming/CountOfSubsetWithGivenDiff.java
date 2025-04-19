package dynamicprogramming;

public class CountOfSubsetWithGivenDiff {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3};
        int diff = 1;
        int len = nums.length;
        int sumArr = 0;
        for(int n:nums){
            sumArr+=n;
        }
        //Check notes for thi calculation
        int requiredSum = (sumArr+diff)/2;
        int[][] dp = new int[len+1][requiredSum+1];
        System.out.println(numOfSubsets(nums,requiredSum,len,dp));
    }
    public static int numOfSubsets(int[] nums, int sum, int len, int[][] dp){
        //Initialisation
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
