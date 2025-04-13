package dynamicprogramming;

public class SubsetSumTopDown {
    public static void main(String[] args) {
        int[] nums = {2,3,7,8,10};
        int sum = 11;
        int len = nums.length;
        boolean[][] dp = new boolean[len+1][sum+1];
        System.out.println(isSubsetPresent(nums,sum,len,dp));
    }
    public static boolean isSubsetPresent(int[] nums,int sum, int len, boolean[][] dp){
        //Initialisation of 0th row and column
        for(int i=0;i<=len;i++){
            for(int j=0;j<=sum;j++){
                //Case where sum is 0 so any length of array can fulfil this condition with an empty subset
                if(j==0){
                    dp[i][j]=true;
                }
                //Case where length of array is 0 so any sum >= 1 cannot satisfy the condition hence false
                if(i==0 && j!=0){
                    dp[i][j]=false;
                }
            }
        }
        //Iterative code
        for(int i=1;i<=len;i++){
            for(int j=1;j<=sum;j++){
                if(nums[i-1]<=j){
                    dp[i][j] = (dp[i-1][j-nums[i-1]] || dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[len][sum];
    }
}
