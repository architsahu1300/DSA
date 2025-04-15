package dynamicprogramming;

public class MinSubsetSumDiffTopDown {
    public static void main(String[] args) {
        int[] nums = {1,2,7};
        int len = nums.length;
        int range=0;
        for(int n:nums){
            range+=n;
        }
        boolean[][] dp = new boolean[len+1][range+1];
        //Initialisation
        for(int i=0;i<=len;i++){
            for(int j=0;j<=range;j++){
                if(j==0){
                    dp[i][j]=true;
                }
                if(i==0 && j!=0){
                    dp[i][j]=false;
                }
            }
        }
        System.out.println(minDiff(nums,range,len,dp));
    }
    public static int minDiff(int[] nums, int range, int len, boolean[][] dp){
        for(int i=1;i<=len;i++){
            for(int j=1;j<=range;j++){
                if(nums[i-1]<=j){
                    dp[i][j] = (dp[i-1][j-nums[i-1]] || dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int minSum=Integer.MAX_VALUE;
        //Now we loop over the last row of dp matrix to get the set of possible sums
        for(int i=0;i<=range/2;i++){
            if(dp[len][i]){
                //Range-2*S1 minimised only for the sums which are possible (set as true in dp matrix)
                minSum=Math.min(minSum,range-2*i);
            }
        }
        return minSum;
    }
}
