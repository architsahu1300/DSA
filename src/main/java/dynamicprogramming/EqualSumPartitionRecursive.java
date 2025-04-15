package dynamicprogramming;

public class EqualSumPartitionRecursive {
    public static void main(String[] args) {
        int[] nums = {1,5,11,6};
        int len = nums.length;
        int sum=0;
        for(int n:nums){
            sum+=n;
        }
        if(sum%2!=0) {
            System.out.println(false);
            return;
        }
        System.out.println(isPartitionPossible(nums,sum/2,len));
    }
    public static boolean isPartitionPossible(int[] nums, int sum, int len){
        if(sum==0) return true;
        if(len==0 && sum!=0) return false;
        if(nums[len-1]<=sum){
            return (isPartitionPossible(nums,sum-nums[len-1],len-1) || isPartitionPossible(nums,sum,len-1));
        }
        else{
            return isPartitionPossible(nums,sum,len-1);
        }
    }

}
