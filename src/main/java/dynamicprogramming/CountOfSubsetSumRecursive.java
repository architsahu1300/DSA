package dynamicprogramming;

public class CountOfSubsetSumRecursive {
    public static void main(String[] args) {
        int[] nums = {2,3,5,6,7,8,10};
        int sum = 10;
        int len = nums.length;
        System.out.println(numOfSubsets(nums,sum,len));
    }
    public static int numOfSubsets(int[] nums, int sum, int len){
        if(sum==0) return 1;
        if(len==0 && sum!=0) return 0;
        if(nums[len-1]<=sum){
            return numOfSubsets(nums,sum-nums[len-1],len-1) + numOfSubsets(nums,sum,len-1);
        }
        else{
            return numOfSubsets(nums,sum,len-1);
        }
    }
}
